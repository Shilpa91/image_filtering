package ImgPckg;

public class ImageFilterFactory {
    public ImageFilter getFilter(String item) {
        // Creates and return an object of type ImgPckg.GrayScale
        if (item.equalsIgnoreCase("ImgPckg.GrayScale")) {

            return new GrayScale();
        }

        // Creates and return an object of type ImgPckg.LogColorScale
        if (item.equalsIgnoreCase("ImgPckg.LogColorScale")) {

            return new LogColorScale();
        }

        // Creates and return an object of type ImgPckg.CharcoalScale
        if (item.equalsIgnoreCase("ImgPckg.CharcoalScale")) {

            return new CharcoalScale();
        }

        // Creates and return an object of type ImgPckg.OriginalImageFilter
        if (item.equalsIgnoreCase("OriginalScale")) {

            return new OriginalImageFilter();
        }

        // Creates and return an object of type ImgPckg.ImplodeFilter
        if (item.equalsIgnoreCase("ImplodeScale")) {

            return new ImplodeFilter();
        }

        return null;
    }
}
