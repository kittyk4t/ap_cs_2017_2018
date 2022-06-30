import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /** sets both Red and Green values to 0 8 */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** negates all color values in the picture */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i=0; i<pixels.length; i++)
        {
            for (int j=0; j<pixels[i].length; j++)
            {
                pixels[i][j].setRed(255-pixels[i][j].getRed());
                pixels[i][j].setGreen(255-pixels[i][j].getGreen());
                pixels[i][j].setBlue(255-pixels[i][j].getBlue());
            }
        }
    }

    /** alters pixel colros to make fish easier to see */
    public void fixWater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if(pixelObj.getRed()<=25 && pixelObj.getBlue()>=160)
                {
                    pixelObj.setBlue(pixelObj.getBlue()-20);
                    pixelObj.setRed(pixelObj.getRed()-20);
                    pixelObj.setGreen(pixelObj.getGreen()-20);
                }
                else
                {
                    pixelObj.setBlue(pixelObj.getBlue()+15);
                    pixelObj.setRed(pixelObj.getRed()+15);
                    pixelObj.setGreen(pixelObj.getGreen()+15);

                }
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from top to bottom */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < pixels[0].length ; col++)
            {
                topPixel = pixels[row][col];
                botPixel = pixels[pixels.length-1-row][col];
                botPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from bottom to top */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < pixels[0].length ; col++)
            {
                topPixel = pixels[row][col];
                botPixel = pixels[pixels.length-1-row][col];
                topPixel.setColor(botPixel.getColor());
            }
        } 
    }

    /** Mirror diagonally left to right*/
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int maxSide=0;
        if(pixels.length<pixels[0].length)
        {
            maxSide=pixels.length;
        }
        else
        {
            maxSide=pixels[0].length;
        }

        for(int i=0; i<maxSide; i++)
        {
            for(int j=0; j<maxSide; j++)
            {
                leftPixel=pixels[j][i];
                rightPixel=pixels[i][j];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println(count);
    }

    /**
     * Method mirrors the arms of a snowman to make 4
     */
    public void mirrorArms()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        int mirrorPoint1=191;
        int mirrorPoint2=195;

        // start edge arm1 row 170 col 102
        //lower edge arm1 191 169
        //top edge arm1 160 122

        // start edge arm2 181 239
        // end edge arm2 195 294
        // top edge arm2 172 283

        for(int i=160; i<mirrorPoint1; i++)
        {
            for (int j=102; j<170; j++)
            {
                topPixel=pixels[i][j];
                botPixel= pixels[mirrorPoint1-i+mirrorPoint1][j];
                botPixel.setColor(topPixel.getColor());
            }
        }

        for(int i=172; i<mirrorPoint2; i++)
        {
            for (int j=239; j<294; j++)
            {
                topPixel=pixels[i][j];
                botPixel= pixels[mirrorPoint2-i+mirrorPoint2][j];
                botPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Method mirrors a seagull on the beach to make 2
     */
    public void mirrorGull()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int mirrorPoint=345;

        // start edge 247 237
        //lower edge 320 270
        //top edge 232 256
        //end edge 288 345

        for(int i=232; i<322; i++)
        {
            for(int j=237; j<mirrorPoint; j++)
            {
                leftPixel=pixels[i][j];
                rightPixel=pixels[i][mirrorPoint-j+mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Converts this picture object to grey scale by iterating through all pixels,
     *      calculating the average of each pixel's RGB values and setting 
     *      all 3 RGB vlaues to that average
     */
    public void convertGreyScale()
    {
        Pixel pixel= null;
        double ave=0;
        for(int i=0; i<this.getWidth(); i++)
        {
            for(int j=0; j<this.getHeight(); j++)
            {
                pixel=this.getPixel(i,j);
                pixel.setRed((int)pixel.getAverage());
                pixel.setGreen((int)pixel.getAverage());
                pixel.setBlue((int)pixel.getAverage());
            }
        }
    }

    /**
     * Converts this picture object to sepia by first converting this picture
     *      to greyScale and iterating through all pixels,
     *      reducing the RGB values of a given pixel based on the red value
     */
    public void convertSepia()
    {
        this.convertGreyScale();
        Pixel pixel=null;
        for(int i=0; i<this.getWidth(); i++)
        {
            for(int j=0; j<this.getHeight(); j++)
            {
                pixel=this.getPixel(i,j);

                if(pixel.getRed()<60)
                {
                    pixel.setRed((int)(pixel.getRed()*.9));
                    pixel.setGreen((int)(pixel.getGreen()*.9));
                    pixel.setBlue((int)(pixel.getBlue()*.9));
                }
                else if(pixel.getRed()<190)
                {
                    pixel.setBlue((int)(pixel.getBlue()*.8));
                }
                else
                {
                    pixel.setBlue((int)(pixel.getBlue()*.9));
                }
            }
        }

    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;

        for (int fromCol = 0, toCol = startCol; 
        fromCol < fromPic.getWidth() &&
        toCol < this.getWidth();  
        fromCol++, toCol++)
        {
            for (int fromRow = 0, toRow = startRow; 
            fromRow < fromPic.getHeight() &&
            toRow < this.getHeight(); 
            fromRow++, toRow++)
            {
                fromPixel = fromPic.getPixel(fromCol,fromRow);
                toPixel = this.getPixel(toCol,toRow);
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /**
     * Copies a region of the specified source Picture object
     *      into this Picture object at the specified location
     *      
     *@param sourcePic picture being copied and cropped
     *@param startSourceRow y coorindate that starts cropped section
     *@param endSourceRow y coorindate that ends cropped section
     *@param startSourceCol x coorindate that starts cropped section
     *@param endSourceCol x coorindate that ends cropped section
     *@param startDestRow first y coorindate where the source picture 
     *      is copied into this picture object
     *@param startDestCol first x coorindate where the source picture 
     *      is copied into this picture object
     */
    public void cropAndCopy(Picture sourcePic, int startSourceRow,
    int endSourceRow, int startSourceCol,int endSourceCol, int startDestRow,
    int startDestCol)
    {
        Pixel sourcePixel = null;
        Pixel destPixel = null;
        int rowDiff= startDestRow-startSourceRow;
        int colDiff= startDestCol-startSourceCol;
        for(int i=startSourceCol; i<=endSourceCol; i++)
            for (int j=startSourceRow; j<=endSourceRow; j++)
            {
                {
                    sourcePixel=sourcePic.getPixel(i,j);
                    destPixel=this.getPixel(i+colDiff,j+rowDiff);
                    destPixel.setColor(sourcePixel.getColor());
                }
            }
    }

    /**
     * Scales picture by half its original size
     * 
     * @return new scaled picture
     */
    public Picture scaleByHalf()
    {
        Picture scaledPic=new Picture((int)(this.getHeight()*.5),
                (int)(this.getWidth()*.5));
        Pixel sourcePixel = null;
        Pixel destPixel = null;

        for(int i=0; i<this.getWidth(); i++)
        {
            for(int j=0; j<this.getHeight(); j++)
            {
                sourcePixel=this.getPixel(i,j);
                destPixel=scaledPic.getPixel((int)(i*.5),(int)(j*.5));
                destPixel.setColor(sourcePixel.getColor());

            }
        }
        return scaledPic;
    }

    /**
     * Scales picture by a given size
     * 
     * @return new scaled picture
     */
    public Picture scaleToSize(int height, int width)
    {
        double ratioRows;
        double ratioCols;

        ratioRows=height;
        ratioRows/=this.getHeight();

        ratioCols=width;
        ratioCols/=this.getWidth();

        Picture scaledPic=new Picture(height,width);
        Pixel sourcePixel = null;
        Pixel destPixel = null;

        for(int i=0; i<this.getWidth(); i++)
        {
            for(int j=0; j<this.getHeight(); j++)
            {
                sourcePixel=this.getPixel(i,j);
                destPixel=scaledPic.getPixel((int)(i*ratioCols),(int)(j*ratioRows));
                destPixel.setColor(sourcePixel.getColor());
            }
        }

        destPixel=null;
        sourcePixel=null;

        for(int i=0; i<scaledPic.getWidth(); i++)
        {
            for(int j=0; j<scaledPic.getHeight(); j++)
            {
                destPixel=scaledPic.getPixel(i,j);
                double ave=destPixel.getAverage();

                if((int)ave==255)
                {
                    if(i>0 && j>0)
                    {
                        sourcePixel=scaledPic.getPixel(i-1,j-1);
                        destPixel.setColor(sourcePixel.getColor());
                    }

                    else if(i==scaledPic.getWidth()-1)
                    {
                        sourcePixel=scaledPic.getPixel(i+1,j-1);
                        destPixel.setColor(sourcePixel.getColor());
                    }
                    else if(j==scaledPic.getHeight()-1)
                    {
                        sourcePixel=scaledPic.getPixel(i-1,j+1);
                        destPixel.setColor(sourcePixel.getColor());
                    }
                    else
                    {
                        sourcePixel=scaledPic.getPixel(i+1,j+1);
                        destPixel.setColor(sourcePixel.getColor());
                    }
                }
            }
        }
        return scaledPic;
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture cosi=new Picture ("cosi.jpg");
        Picture rocky=new Picture ("rocky.jpg");
        Picture bear=new Picture ("bear.jpg");
        Picture squirt=new Picture("squirt.jpg");
        Picture cassisus=new Picture ("cassisus.jpg");
        Picture quigley=new Picture("quigley.jpg");
        Picture stanley=new Picture("stanley.jpg");
        Picture fluffy=new Picture("fluffy2.jpg");
        Picture fluffy2=new Picture("fluffy3.jpg");
        
        Picture sky=new Picture("navy.jpg");

        
        cosi=cosi.scaleToSize(475,500);
        bear=bear.scaleToSize(650,600);
        rocky=rocky.scaleToSize(650,600);
        squirt=squirt.scaleToSize(550,500);
        cassisus=cassisus.scaleToSize(475,500);
        quigley=quigley.scaleToSize(475,500);
        stanley=stanley.scaleToSize(475,500);
        fluffy=fluffy.scaleToSize(475,500);
        

        fluffy.convertGreyScale();
        rocky.convertSepia();
        fluffy2.convertSepia();
        cassisus.mirrorVertical();
        squirt.mirrorVerticalRightToLeft();
        squirt.convertGreyScale();

        this.copy(sky,0,0);
        this.cropAndCopy(fluffy,50,300,0,300,20,20);
        this.cropAndCopy(bear,200,350,300,425,70,430);
        this.cropAndCopy(stanley,200,380,300,420,220,420);
        this.cropAndCopy(quigley,120,300,50,320,90,220);
        
        this.cropAndCopy(fluffy2,100,300,75,150,260,95);
        
        this.cropAndCopy(fluffy2,200,300,75,150,360,75);
        this.cropAndCopy(fluffy2,200,300,75,150,360,55);
        this.cropAndCopy(fluffy2,200,300,75,150,360,35);
        this.cropAndCopy(fluffy2,200,300,75,150,360,30);
        
        this.cropAndCopy(fluffy2,100,200,75,150,260,80);
        this.cropAndCopy(fluffy2,100,200,75,150,260,65);
        this.cropAndCopy(fluffy2,100,200,75,150,260,55);
        this.cropAndCopy(fluffy2,100,200,75,150,260,45);
        this.cropAndCopy(fluffy2,100,200,75,150,260,35);
        this.cropAndCopy(fluffy2,100,200,75,150,260,25);
        
        this.cropAndCopy(squirt,280,500,20,200,350,170);
        this.cropAndCopy(cassisus,250,450,230,470,370,345);
        this.cropAndCopy(stanley,250,380,220,350,270,270);
        this.cropAndCopy(cosi,220,400,300,400,180,170);
        this.cropAndCopy(rocky,250,380,220,350,245,345);

        
        this.write("KWieser.jpg");
    }
    
    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
