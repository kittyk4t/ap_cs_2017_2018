import java.awt.Color;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect.
 *
 * @author kittyk4t
 * @version 9 November 2017
 */
public class ShepardFairey
{
    private Picture picture;

    //RGB values from RapidTables.com
    private static final Color PURPLE=new Color (51,0,102);
    private static final Color MAROON=new Color(110,0,51);//altered RGB values slightly
    private static final Color LILAC=new Color(204,204,255);
    private static final Color MY_WHITE=new Color(248,248,255);
    
    //original colors
    private static final Color OFF_WHITE = new Color( 248, 229, 175 );
    private static final Color LIGHT_BLUE = new Color( 121, 149, 159 );
    private static final Color RED = new Color( 198, 50, 45 );
    private static final Color DARK_BLUE = new Color( 16, 48, 77 );

    //numbers that define the range of values
    private int maxValue; //lightest value (closest to 255)
    private int minValue; //darkest value (closest to 0)
    private int medValue; //value in middle of the true darkest and lightest values
    private int lightMed; //cutoff of light midtones
    private int darkMed; //cutoff of dark midtones
    
    /**
     * Constructor, sets parameter value to instance variable picture
     * 
     * @param newPicture picture object
     */
    public ShepardFairey( Picture newPicture )
    {
        this.picture = newPicture;
    }

    /**
     * Takes the average of a pixel's RGB values, and sets each value to the average
     * This produces a shade of grey that is the same intensity as the color before
     */
    public void setGreyScale()
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
     * Finds the lightest grey value 
     * @precondition this method is meant to be used AFTER setGreyScale,
     *      if setGreyScale is not called before, it will find the greatest red value 
     *      
     *return lightValue interger of the darkest grey value
     */
    public void setMaxValue()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                
                if (pixel.getRed()>maxValue)
                {
                    maxValue=pixel.getRed();
                }
            }
        }
        
    }
    
    /**
     * Finds the darkest grey value
     *  @precondition this method is meant to be used AFTER setGreyscale,
     *      if setGreyScale is not called before, it will return the lowest red value 
     */
    public void setMinValue()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                
                if (pixel.getRed()<minValue)
                {
                    minValue=pixel.getRed();
                }
            }
        }
        
    }
    
    /**
     * Finds the size of each subsection, and then assigns values to each subsection
     */
    public void calcValues()
    {
        this.setMaxValue();
        this.setMinValue();
        
        int range=maxValue-minValue;
        medValue=minValue+(range/2);
        range/=4;
        lightMed=medValue+range;
        darkMed=medValue-range;
    }
    
    /**
     * Takes the four equal subranges of grey values, and "shepardfaireydizes" the picture
     *      i.e. replaces grey values with 4 different colors, 
     *      each representing a different subrange
     */
    public void convertValues()
    {
         int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        for (int y=0; y <height; y++)
        {
            for (int x=0; x <width; x++)
            {
                Pixel pixel=this.picture.getPixel(x, y);
                
                if (pixel.getRed()<darkMed)
                {
                    pixel.setColor(PURPLE);
                }
                else if(pixel.getRed()<medValue)
                {
                    pixel.setColor(MAROON);
                }
                else if(pixel.getRed()<lightMed)
                {
                    pixel.setColor(LILAC);
                }
                else
                {
                   pixel.setColor(MY_WHITE);
                }
            }
        }
    }
    
    public void transform()
    /**
     * Transforms the picture by applying a Shepard Fairey-inspired effect.
     *
     */
    
    {
        this.setGreyScale();
        this.calcValues(); 
        this.convertValues();
    }

    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        Picture selfie = new Picture( "unnamed.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey fairey = new ShepardFairey( selfie );

        // display the original selfie picture
        selfie.explore();

        // transform the selfie picture by applying a Shepard Fairey-inspired effect
        fairey.transform();
        

        // save the transformed selfie picture
        
        /* This code doesn't work for some students for unknown reasons.
         * You may need to specify an absolute path. For example:
         *  finalPic.write("C:\\Users\\gschmit\\Desktop\\GitHub\\unit6MediaComp\\images\\Schmit.jpg");
         */
        selfie.write("C:\\Users\\kwieser\\GitHub\\decisions-loops-kittyk4t\\Shepard Fairey\\KatianaWieser_Portrait.jpg" );

        // display the transformed selfie picture
        selfie.explore();
    }
}