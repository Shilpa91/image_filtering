package ImgPckg;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import magick.*;

import java.io.File;


public class GrayScale implements ImageFilter {
    //Implementing abstract function of interface ImgPckg.ImageFilter
    @Override
    public ImageView filter(File SelectedFile){

        ImgUtils ImgUtilObj = new ImgUtils();

        // If download directory doesn't exist, create it
        String tempdirpath = ImgUtilObj.createtempdir();
        try {

            // Gray scale filtering: Create ImageMagick Object
            ImageInfo info = new ImageInfo(SelectedFile.getAbsolutePath());
            MagickImage image = new MagickImage(info); //load image

            // Gray scale filtering: Apply filter
            QuantizeInfo QI = new QuantizeInfo();
            QI.setColorspace(ColorspaceType.GRAYColorspace);
            QI.setNumberColors(256);
            QI.setTreeDepth(8);
            image.quantizeImage(QI);

            Tags.tag = "_grayfiltered_";
            String filePath = tempdirpath + Tags.SelectedFile.getName();

            // Gray scale filtering: Write image to temp file
            image.setFileName(filePath);
            image.writeImage(info);
            Image imageObj = new Image("file:" + filePath);
            ImageView FilteredImageView = new ImageView(imageObj);

            // Gray scale filtering: Update selected file and return view
            Tags.SelectedFile = new File(filePath);
            return FilteredImageView;

        } catch (MagickException f) {
            f.printStackTrace();
        }
        return null;
    }
}
