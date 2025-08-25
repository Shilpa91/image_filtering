package ImgPckg;

public class GifImage extends Formats implements ImageFormat {
    //Implementing abstract function of interface ImgPckg.ImageFormat
    @Override
    public void format(){
        // Calls function present in extended class ImgPckg.Formats
        commonFormat();
    }
}
