package ImgPckg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;


// Image Utilities class to  create directory and progressbar
// Uses encapsulation to hide class variables and allows to set/access methods using the set/get methods

public class ImgUtils {

    private static Image image;
    private static File SelectedFile;
    private static String format;

    public void SetImage(Image image){
        this.image = image;
    }

    public void SetSelectedFile(File SelectedFile){
        this.SelectedFile = SelectedFile;
    }

    public void SetFormat(String format){this.format=format;}

    public Image GetImage(){
        return this.image;
    }

    public File GetSelectedFile(){
        return this.SelectedFile;
    }
    public String GetFormat(){
        return this.format;
    }



    public String createdir(){

        String downloaddirpath = SelectedFile.getPath().replace(SelectedFile.getName(), "Downloaded_Images\\");
        downloaddirpath = downloaddirpath.replace("FilterTemp\\","");

        File directory = new File(downloaddirpath);
        if (! directory.exists()){
            directory.mkdir();
        }
        return downloaddirpath;
    }

    public String createtempdir(){

        String downloaddirpath = SelectedFile.getPath().replace("FilterTemp\\","");

        downloaddirpath = downloaddirpath.replace(SelectedFile.getName(), "FilterTemp\\");
        File directory = new File(downloaddirpath);
        if (! directory.exists()){
            directory.mkdir();
        }
        return downloaddirpath;
    }

    public static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();

    }

    // ProgressIndicator appears if there is delay in uploading selected images
    public void createProgressIndicator(Stage stage){


        // Instantiating ProgressIndicator
        ProgressIndicator indicator  = new ProgressIndicator();
        // Notify the user that image is being loaded
        indicator.setProgress(-1.0f);

        // Setting label
        Label label= new Label("Loading");
        label.setStyle("-fx-font-size:18px");
        VBox vbox  = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, indicator);
        Scene scene1 = new Scene(vbox,200,200);
        stage.setScene(scene1);
        stage.show();

    }

}
