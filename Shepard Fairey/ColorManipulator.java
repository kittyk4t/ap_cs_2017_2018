import java.awt.Color;

/**
 * Class that manipulates the colors in a specified picture
 *
 * @author kittyk4t
 * @version 7 November 2017
 */
public class ColorManipulator
{
    private Picture picture;

    /**
     * Constructs a new ColorManipulator object with the specified picture
     *
     * @param  newPicture  the picture to manipulate
     */
    public ColorManipulator( Picture newPicture )
    {
        this.picture = newPicture;
    }

    /**
     * Sets the blue component of the color of every pixel in the picture to the maximum value
     *
     *      An example of manipulating one component of the color of a pixel.
     */
    public void maxBlue()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                pixel.setBlue( 255 );
            }
        }
    }

    /**
     * Sets the red component of the color of every pixel
     *  in the picture to the maximum value
     *
     *      An example of manipulating one component of the color of a pixel.
     */
    public void maxRed()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                pixel.setRed(255);
            }
        }
    }

    /**
     * Sets the green component of the color of every pixel 
     *      in the picture to the maximum value
     *
     *      An example of manipulating one component of the color of a pixel.
     */
    public void maxGreen()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                pixel.setGreen(255);
            }
        }
    }

    /**
     * Negates the color of every pixel in the picture
     *
     *      An example of manipulating the color of a pixel using a Color object
     */
    public void negate()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                Color color = pixel.getColor();

                int negatedRed = 255 - color.getRed();
                int negatedBlue = 255 - color.getBlue();
                int negatedGreen = 255 - color.getGreen();

                Color negated = new Color( negatedRed, negatedBlue, negatedGreen );
                pixel.setColor( negated );
            }
        }
    }

    /**
     * Takes the average of a pixel's RGB values, and sets each value to the average
     * This produces a shade of grey that is the same intensity as the color before
     */
    public void setGrayScale()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                int sumVal=pixel.getBlue()+pixel.getRed()+pixel.getGreen();
                int aveVal=sumVal/3;
                Color greyVal=new Color(aveVal,aveVal,aveVal);
                pixel.setColor(greyVal);
            }
        }
    }

    /**
     * Gets the Red value of a specified pixel
     * 
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * 
     * @return returns the Red interger value of the pixel
     */
    public int getRedValue(int x, int y)
    {
        Pixel pixel=this.picture.getPixel(x, y);

        return pixel.getRed();
    }

    /**
     * Gets the Green value of a specified pixel
     * 
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * 
     * @return returns the Green interger value of the pixel
     */
    public int getGreenValue(int x, int y)
    {
        Pixel pixel=this.picture.getPixel(x, y);

        return pixel.getGreen();
    }

    /**
     * Gets the Blue value of a specified pixel
     * 
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * 
     * @return returns the Blue interger value of the pixel
     */
    public int getBlueValue(int x, int y)
    {
        Pixel pixel=this.picture.getPixel(x, y);

        return pixel.getBlue();
    }

    /**
     * Creates Picture and ColorManipulator objects,
     *      uses ColorManipulator methods to alter the picture
     */
    public static void main(String args[])
    {
        //the selfie image must be in the Shepard Fairey folder
        Picture picture= new Picture( "IMG_5613.jpg" );
        ColorManipulator manipulator = new ColorManipulator( picture );
        picture.explore();
        //manipulator.maxBlue();
        //manipulator.maxRed();
        //manipulator.maxGreen();
        manipulator.setGrayScale();
        //manipulator.negate();
        picture.explore();
    }
}
