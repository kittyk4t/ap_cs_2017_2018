
/**
 * Creates a Doric order column, meant to be used in conjugation with the Temple class
 *
 * @author kittyk4t
 * @version 5 October 2017
 */
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

public class Column
{
    private double height; //height of column shaft
    private double width; //width of column shaft
    private int xPos; //x coorindate of upper left corner of shaft
    private int yPos; //y coorindate of upper left corner of shaft
    
    //RGB values from http://www.tayloredmktg.com/rgb/
    private final Color ivory=new Color(255,255,240);
    
    /**
     * Intializes xPos,yPos and height of column to specified values,
     *      and width to half of height
     *      
     *@param x the x-coorindate 
     *      of the upper left hand corner of this column shaft
     *@param y the y-coorindate 
     *      of the upper left hand corner of this column shaft
     *@param h the height of this column
     */
    public Column(int x, int y, int h)
    {
        this.xPos=x;
        this.yPos=y;
        this.height=h;
        this.width=height*.25;
    }
    
    /**
     * Creates all aspects of the column (shaft,flutes,capital,necking etc)
     * Draws some aspects in a black outline
     * Fills some aspects in ivory
     * 
     * @param g2 Graphical Context
     */
    public void draw(Graphics2D g2)
    {
        //shaft (main part) of column
        Ellipse2D.Double shaft= new Ellipse2D.Double(xPos,yPos,width,height);

        //base of column
        Rectangle base = new Rectangle(xPos,yPos+(int)(height-height*1/15),(int)width,(int)(height*1/15));

        //Circular part of capital
        Ellipse2D.Double circle= new Ellipse2D.Double(xPos,yPos-width,width,(height*1/3));

        //top of capital
        Rectangle top = new Rectangle(xPos,yPos-(int)(width*3/4),(int)width,(int)(height*1/15));

        //necking of capital
        Rectangle necking1 = new Rectangle(xPos,yPos+(int)(width*1/3),(int)width, (int)(height*1/25));
        Rectangle necking2 = new Rectangle(xPos,yPos,(int)width, (int)(height*1/25));

        //flutes of column
        Line2D.Double flute1=new Line2D.Double(xPos+(width*1/5),yPos+(int)((width*1/3)+(height*1/25)),
                xPos+(width*1/5),yPos+height);

        Line2D.Double flute2=new Line2D.Double(xPos+(width*1/3),yPos+(int)((width*1/3)+(height*1/25)),
                xPos+(width*1/3),yPos+height);

        Line2D.Double flute3=new Line2D.Double(xPos+(width*1/2),yPos+(int)((width*1/3)+(height*1/25)),
                xPos+(width*1/2),yPos+height);

        Line2D.Double flute4=new Line2D.Double(xPos+(width*2/3),yPos+(int)((width*1/3)+(height*1/25)),
                xPos+(width*2/3),yPos+height);

        Line2D.Double flute5=new Line2D.Double(xPos+(width*7/8),yPos+(int)((width*1/3)+(height*1/25)),
                xPos+(width*7/8),yPos+height);
        
        //fills in shaft of column in ivory
        g2.setColor(ivory);
        g2.fill(shaft);
        
        //draws black lines of flutes
        g2.setColor(Color.BLACK);
        g2.draw(flute1);
        g2.draw(flute2);
        g2.draw(flute3);
        g2.draw(flute4);
        g2.draw(flute5);
        
        //fills in base, top of and circular part of capital of column
        //NOTE: this is done after the flutes are drawn so that these filled shapes cover the excess length of the lines
        g2.setColor(ivory);
        g2.fill(base);
        g2.fill(circle);
        g2.fill(top);
        
        //draws black outlines of the necking and top of the column
        //NOTE: this goes after the capital is filled so that those shapes don't overlap and cover these lines
        g2.setColor(Color.BLACK);
        g2.draw(necking1);
        g2.draw(necking2);
        g2.draw(top);

    }
    
    /**
     * Returns the height of the column shaft as a double
     * 
     * @return height of column shaft
     */
    public double getHeight()
    {
        return this.height;
    }
        
}

