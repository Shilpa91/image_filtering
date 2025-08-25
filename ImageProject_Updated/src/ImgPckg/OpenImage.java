package ImgPckg;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.List;

public class OpenImage {


    public static void chooseImage(Stage primaryStage){

        // Creating a TilePane layout(tile) with 4 rows and 4 columns for displaying multiple images
        TilePane tile = new TilePane(); //layout
        tile.setVgap(10);
        tile.setHgap(10);
        tile.setPrefColumns(4);
        tile.setPrefRows(4);
        Tags.tag = "_original_";
        // Allow users to select multiple files
        FileChooser fc = new FileChooser();
        //creating button
        Button BackBtn = new Button("Back");
        BackBtn.setStyle("-fx-font-size:18px");

        // BackBtn allows users to cancel current selection and make new selection.
        BackBtn.setOnAction(e -> OpenImage.chooseImage(primaryStage));

        List<File> FileList = fc.showOpenMultipleDialog(primaryStage); // upload multiple image

        // Instantiating ImgPckg.ImgUtils
        ImgUtils imageutil = new ImgUtils();

        // Progress indicator displayed while loading multiple images
        imageutil.createProgressIndicator(primaryStage);


        // Counter keeps track of no of images selected by user
        int counter=0;
        if (FileList != null) {

            // Looping over all selected files
            for (File SelectedFile : FileList) {
                Tags.SelectedFile = SelectedFile;
                counter++;

                // Original image
                Image OrigImag = new Image("file:" + SelectedFile.getPath());
                // Resized image
                Image ThumbImag = new Image("file:" + SelectedFile.getPath(), 100, 100, false, false);
                ImageView ThumbImagView = new ImageView(ThumbImag);

                imageutil.SetImage(OrigImag);
                imageutil.SetSelectedFile(Tags.SelectedFile);

                // click event handling: open stage for filtering and/or downloading images
                ThumbImagView.setOnMouseClicked(f ->  ImageConversions.processImage(OrigImag,SelectedFile));

                // hover event handling
                ThumbImagView.setOnMouseEntered(g -> DisplayProperty.dispProperties(SelectedFile,OrigImag,ThumbImagView));

                // push the image to TilePane
                tile.getChildren().addAll(ThumbImagView);

                // delete temp folder upon closing stage, resulting images in Downloaded_Images folder
                primaryStage.setOnCloseRequest(event -> {
                    ImgUtils.deleteDirectory(new File(SelectedFile.getParentFile().getAbsolutePath()+"\\FilterTemp\\"));
                });

            }


            // Displays no of images selected by users
            String title;
            if(counter==1) {
                title = counter + " Image Selected";
            }
            else{
                title = counter + " Images Selected";
            }


            // ScrollPane for browsing the selected images
            ScrollPane scroll = new ScrollPane();
            scroll.setPadding(new Insets(5, 0, 5, 5));

            // Setting TilePane as content of ScrollPane
            scroll.setContent(tile);

            // Creating a VBox layout(vbox)
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.TOP_RIGHT);
            vbox.setSpacing(5);

            // Setting ScrollPane as content of vbox
            vbox.getChildren().addAll(BackBtn,scroll);
            Scene scene = new Scene(vbox, 455, 485);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();


        } else { //exit program if user is not selecting image.

            primaryStage.close();
        }

    }




}
