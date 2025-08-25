package ImgPckg;

import javafx.scene.image.ImageView;

import java.io.File;
// Interface ImgPckg.ImageFilter is implemented by concrete class LogColorSpace, ImgPckg.GrayScale, ImgPckg.CharcoalScale
// ImgPckg.ImplodeFilter, and ImgPckg.OriginalImageFilter
public interface ImageFilter {

    //abstract function
    ImageView filter(File SelectedFile);
}
