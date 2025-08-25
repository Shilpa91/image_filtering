package ImgPckg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class ImageConversions {
    public static  void processImage(Image OrigImag,File SelectedFile){

        // Create a border pane to let user filter or download images
        System.out.println("Clicked: " + SelectedFile.getPath());
        Stage FullImStage = new Stage();
        // Blocks events from being delivered to any other application window
        FullImStage.initModality(Modality.APPLICATION_MODAL);

        ImageView OrigImagView = new ImageView(OrigImag);
        BorderPane bpane = new BorderPane();

        // Top Set Heading Text
        Label heading = new Label("Filter or Download the below image");
        heading.setFont(new Font("Open Sans", 20));
        heading.setStyle("-fx-font-weight: bold; -fx-font-size: 20pt;");
        HBox TextHbox = new HBox();
        TextHbox.setAlignment(Pos.CENTER);
        TextHbox.getChildren().addAll(heading);
        bpane.setTop(TextHbox);

        // Center Set Image
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(OrigImagView);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        bpane.setCenter(scrollPane);

        // Right Set Download Button
        MenuButton DownloadBtn = new MenuButton("Download As");
        MenuItem jpg = new MenuItem("JPG");
        MenuItem png = new MenuItem("PNG");
        MenuItem bmp = new MenuItem("BMP");
        MenuItem gif = new MenuItem("GIF");

        // Add menu items to download button dropdown
        DownloadBtn.getItems().addAll(jpg,png,bmp,gif);
        VBox DownloadVbox = new VBox();
        DownloadVbox.setAlignment(Pos.CENTER);
        DownloadVbox.getChildren().addAll(DownloadBtn);
        bpane.setRight(DownloadVbox);


        ImgUtils util=new ImgUtils();
        util.SetImage(OrigImag);
        util.SetSelectedFile(SelectedFile);


        // Instantiating imageFormatFactory
        ImageFormatFactory imageformatfactory=new ImageFormatFactory();

        // JPG image conversion click event
        jpg.setOnAction(e -> {
            ImageFormat f1 = imageformatfactory.getFormat("jpg");
            util.SetFormat(".jpg");
            f1.format();
        });
        // PNG image conversion click event
        png.setOnAction(e -> {
            ImageFormat f1 = imageformatfactory.getFormat("png");
            util.SetFormat(".png");
            f1.format();
        });
        // BMP image conversion click event
        bmp.setOnAction(e -> {
            ImageFormat f1 = imageformatfactory.getFormat("bmp");
            util.SetFormat(".bmp");
            f1.format();
        });
        // GIF image conversion click event
        gif.setOnAction(e -> {
            ImageFormat f1 = imageformatfactory.getFormat("gif");
            util.SetFormat(".gif");
            f1.format();
        });

        // Left Set Filter Button
        MenuButton FilterBtn = new MenuButton("Apply Filter");
            MenuItem gsf = new MenuItem("GrayScale");
        MenuItem lcs = new MenuItem("LogColorScale");
        MenuItem charcoal = new MenuItem("CharcoalScale");
        MenuItem original = new MenuItem("OriginalScale");
        MenuItem implode = new MenuItem("ImplodeScale");

        // Add menu items to filter button dropdown
        FilterBtn.getItems().addAll(gsf,implode,lcs,charcoal,original);
        VBox FilterVbox = new VBox();
        FilterVbox.setAlignment(Pos.CENTER);
        FilterVbox.getChildren().addAll(FilterBtn);
        bpane.setLeft(FilterVbox);

        // Instantiating imageFilterFactory
        ImageFilterFactory filterfactory= new ImageFilterFactory();

        // Grayscale filtering click event
        gsf.setOnAction(e -> {
            ImageFilter f1 = filterfactory.getFilter("ImgPckg.GrayScale");
            // Update scroll pane content with Gray scale filtered view
            scrollPane.setContent(f1.filter(SelectedFile));
        });
        // Implode filtering click event
        implode.setOnAction(e -> {
            ImageFilter f1 = filterfactory.getFilter("ImplodeScale");
            // Update scroll pane content with imploded image view
            scrollPane.setContent(f1.filter(SelectedFile));
        });
        // Logscale filtering click event
        lcs.setOnAction(e -> {
            ImageFilter f1 = filterfactory.getFilter("ImgPckg.LogColorScale");
            // Update scroll pane content with Log scale filtered view
            scrollPane.setContent(f1.filter(SelectedFile));
        });
        // Charcoal filtering click event
        charcoal.setOnAction(e -> {
            ImageFilter f1 = filterfactory.getFilter("ImgPckg.CharcoalScale");
            // Update scroll pane content with charcoal view
            scrollPane.setContent(f1.filter(SelectedFile));
        });
        // Original unfiltered image click event
        original.setOnAction(e -> {
            ImageFilter f1 = filterfactory.getFilter("OriginalScale");
            // Update scroll pane content with original view
            scrollPane.setContent(f1.filter(SelectedFile));
        });

        // Bottom Set Info Text
        Label footer = new Label("Filtered images appear in the scrollpane, downloaded images appear in the \'Downloaded_Images\' folder");
        footer.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt;");
        HBox Textbox = new HBox();
        Textbox.setAlignment(Pos.CENTER);
        Textbox.getChildren().addAll(footer);
        bpane.setBottom(Textbox);

        FullImStage.setOnCloseRequest(event -> {
            ImgUtils.deleteDirectory(new File(SelectedFile.getParentFile().getAbsolutePath()+"\\FilterTemp\\"));
        });

        Scene scene2 = new Scene(bpane);
        FullImStage.setScene(scene2);
        FullImStage.show();


    }




}
