package ImgPckg;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import java.io.File;


public class DisplayProperty {

    // Get Properties from the Image
    public static  void dispProperties(File SelectedFile, Image OrigImag, ImageView ThumbImagView){

        ImgUtils Imgutil = new ImgUtils();
        Imgutil.SetImage(OrigImag);
        Imgutil.SetSelectedFile(SelectedFile);

        // Reads pixel information in the original image
        PixelReader pixelReader = OrigImag.getPixelReader();

        if (pixelReader == null) {
            System.out.println("Cannot process image");
        }


        // Capture image width
        int width = (int) OrigImag.getWidth();
        // Capture image height
        int height = (int) OrigImag.getHeight();
        // Capture image location
        String Location = SelectedFile.getAbsolutePath();
        //capture image type(Jpg, png, bmp, gif etc)
        String fname=SelectedFile.getName();
        String extn = fname.substring(fname.lastIndexOf(".") + 1, SelectedFile.getName().length());
        // Capture camera property from image Exif data
        javaxt.io.Image org_image = new javaxt.io.Image(Location);
        java.util.HashMap<Integer, Object> exif = org_image.getExifTags();


        // Creating Tooltip with image properties(Item type, Width, Height, Location, Camera ) as Tooltip text
        Tooltip tooltip = new Tooltip( "Item type: "+extn.toUpperCase()+" File" + '\n' +
                "Width: "+width+'\n' +
                "Height: "+height+'\n'+
                "Location: "+Location+'\n'+
                "Camera: "+ exif.get(0x0110) +"\n");

        // Associate the Tooltip(tooltip) with Thumbimage
        Tooltip.install(ThumbImagView, tooltip);

    }
}
