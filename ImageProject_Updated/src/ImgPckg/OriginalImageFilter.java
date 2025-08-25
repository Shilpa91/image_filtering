package ImgPckg;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import java.io.File;


public class OriginalImageFilter implements ImageFilter {
    //Implementing abstract function of interface ImgPckg.ImageFilter
    @Override
    public ImageView filter(File SelectedFile){

        ImgUtils ImgUtilObj = new ImgUtils();

        // If download directory doesn't exist, create it
        String tempdirpath = ImgUtilObj.createtempdir();
        try {

            // Unfiltered image: Create ImageMagick Object
            ImageInfo info = new ImageInfo(SelectedFile.getAbsolutePath());
            MagickImage image = new MagickImage(info); //load image

            Tags.tag = "_original_";
            String filePath = tempdirpath + Tags.SelectedFile.getName();

            // Write original image to temp file
            image.setFileName(filePath);
            image.writeImage(info);
            Image imageObj = new Image("file:" + filePath);
            ImageView FilteredImageView = new ImageView(imageObj);

            // Update selected file and return view
            Tags.SelectedFile = new File(filePath);
            return FilteredImageView;

        } catch (MagickException f) {
            f.printStackTrace();
        }

        return null;

    }
}
