package ImgPckg;

public class BmpImage extends Formats implements ImageFormat{ //bmp format

    //Implementing abstract function of interface ImgPckg.ImageFormat
    @Override
    public void format(){
        // Calls function present in extended class ImgPckg.Formats
        commonFormat();
    }
}
