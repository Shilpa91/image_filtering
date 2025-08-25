package ImgPckg;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

// This class is extended by ImgPckg.JpgImage, ImgPckg.GifImage, ImgPckg.BmpImage, and ImgPckg.PngImage
public class Formats {

    public void commonFormat(){

        // Instantiating Image Utils class
        ImgUtils ImgUtilObj = new ImgUtils();
        ImgUtilObj.GetImage();
        ImgUtilObj.GetSelectedFile();

        // If download directory doesn't exist, create it
        String downloaddirpath = ImgUtilObj.createdir();

        try {
            // Instantiating ImageInfo class with current SelectedFile
            ImageInfo info = new ImageInfo(Tags.SelectedFile.getAbsolutePath());

            //create ImageMagick object from Image info (load image)
            MagickImage image = new MagickImage(info);

            // Enable format conversion using file extension from ImgPckg.ImgUtils function GetFormat()
            image.setFileName(downloaddirpath + Tags.SelectedFile.getName().replaceFirst("[.][^.]+$", "") + Tags.tag + ImgUtilObj.GetFormat());

            // Write image to target file in the above-specified format
            image.writeImage(info);
        }
        catch (
                MagickException f) {
            f.printStackTrace();
        }
    }
}
