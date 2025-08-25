package ImgPckg;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import magick.QuantizeInfo;

import java.io.File;


public class LogColorScale implements ImageFilter {
    //Implementing abstract function of Interface ImgPckg.ImageFilter
    @Override
    public ImageView filter(File SelectedFile){

        ImgUtils ImgUtilObj = new ImgUtils();

        // If download directory doesn't exist, create it
        String tempdirpath = ImgUtilObj.createtempdir();
        try {

            // Log scale filtering: Create ImageMagick Object
            ImageInfo info = new ImageInfo(SelectedFile.getAbsolutePath());
            MagickImage image = new MagickImage(info); //load image

            // Log scale filtering: Apply filter
            QuantizeInfo QI = new QuantizeInfo();
            QI.setColorspace(2);
            image.quantizeImage(QI);

            Tags.tag = "_logfiltered_";
            String filePath = tempdirpath + SelectedFile.getName();

            // Log scale filtering: Write image to temp file
            image.setFileName(filePath);
            image.writeImage(info);
            Image imageObj = new Image("file:" + filePath);
            ImageView FilteredImageView = new ImageView(imageObj);

            // Log scale filtering: Update selected file and return view
            Tags.SelectedFile = new File(filePath);
            return FilteredImageView;

        } catch (MagickException f) {
            f.printStackTrace();
        }

        return null;

    }
}
