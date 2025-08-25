package ImgPckg;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


// Uses inheritance to extend Application class

public class JavaFXProj extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            // Creating Load button for selecting image
            Button LoadBtn = new Button("Select image");

            // Setting button action( calls the function chooseImage present in class openImage )
            LoadBtn.setOnAction(e -> OpenImage.chooseImage(primaryStage));


            //Setting Label
            Label label = new Label("\n\n\n\n Java Image Processing Project");
            label.setStyle("-fx-font-size: 20px;"+"-fx-font-weight: bold;"+"-fx-text-fill: green;");

            // Creating a VBox layout(vbox)
            VBox vbox = new VBox(60);
            // Setting center alignment for LoadBtn
            vbox.setAlignment(Pos.TOP_CENTER);
            // Adding LoadBtn to vbox
            vbox.getChildren().addAll(label,LoadBtn);
            // Creating scene with specified width and height
            Scene scene = new Scene(vbox, 300, 400);
            // Adding title to stage
            primaryStage.setTitle("Welcome");
            // Adding Scene to stage
            primaryStage.setScene(scene);
            // Display stage
            primaryStage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting JAVA FX Image Processing Project");
        launch(args);

    }

}
