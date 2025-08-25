package ImgPckg;

public class ImageFormatFactory {

    public ImageFormat getFormat(String item) {

        // Creates and return an object of type ImgPckg.JpgImage
        if (item.equalsIgnoreCase("jpg")) {

            return new JpgImage();
        }
        // Creates and return an object of type ImgPckg.PngImage
        if (item.equalsIgnoreCase("png")) {

            return new PngImage();
        }
        // Creates and return an object of type ImgPckg.BmpImage
        if (item.equalsIgnoreCase("bmp")) {

            return new BmpImage();
        }
        // Creates and return an object of type ImgPckg.GifImage
        if (item.equalsIgnoreCase("gif")) {

            return  new GifImage();
        }
        return null;
    }
}
