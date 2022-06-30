
/**
 * Creates a Doric order frieze meant to be used i conjugation with the Temple class
 *
 * @author kittyk4t
 * @version 6 October 2017
 */
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Frieze
{
    private int xPos; // x coorindate of the upper left hand corner of the mainFrieze
    private int yPos; // y coorindate of the upper left hand corner of the mainFrieze
    private int width; //width of the mainFrieze
    private double height; //hieght of the mainFrieze and triglyphs
    
    //RGB values from http://www.tayloredmktg.com/rgb/
    private final Color ivory=new Color(255,255,240);

    /**
     * Constructor Method of Frieze, intializes instance variables, x,y,w to specified amounts and height to 1/10 width
     * 
     * @param x x-coorindate of upper left corner of frieze
     * @param y y-coorindate of upper left corner of frieze
     * @param w width of frieze
     */
    public Frieze(int x, int y, int w)
    {
        this.xPos=x;
        this.yPos=y;
        this.width=w;
        this.height=width*1/10;
    }

    /**
     * Creates all aspects (mainFrieze and triglyphs) of this frieze object
     * Draws black outline of triglyphs
     * Fills ivory shape of mainFrieze
     */
    public void draw(Graphics2D g2)
    {
        Rectangle mainFrieze=new Rectangle(xPos,yPos,width,(int)height);

        //Creating triglyph objects:
        
        //leftmost trigyph
        Rectangle leftT=new Rectangle(xPos,yPos,(int)(width*1/20),(int)height);

        //1st set of triglyphs
        Rectangle t1S1=new Rectangle(xPos+(int)(width*1/4),yPos,(int)(width*1/20),(int)height);
        Rectangle t2S1=new Rectangle(xPos+(int)(width*3/10),yPos,(int)(width*1/20),(int)height);
        Rectangle t3S1=new Rectangle(xPos+(int)((width*7/20)+2/10),yPos,(int)(width*1/20),(int)height);

        //2nd set of triglyphs
        Rectangle t1S2=new Rectangle(xPos+(int)(width*13/20),yPos,(int)(width*1/20),(int)height);
        Rectangle t2S2=new Rectangle(xPos+(int)((width*7/10)),yPos,(int)(width*1/20),(int)height);
        Rectangle t3S2=new Rectangle(xPos+(int)((width*3/4)),yPos,(int)(width*1/20),(int)height);

        //last (rightmost) trigylph
        Rectangle rightT=new Rectangle(xPos+(int)(width*19/20),yPos,(int)(width*1/20),(int)height);

        //fills mainFrieze in ivory-makes a base or "canvas" for triglyphs outlines
        g2.setColor(ivory);

        g2.fill(mainFrieze);

        //draws black outlines of all the trigylphs
        g2.setColor(Color.BLACK);
        g2.draw(mainFrieze);

        g2.draw(leftT);

        g2.draw(t1S1);
        g2.draw(t2S1);
        g2.draw(t3S1);

        g2.draw(t1S2);
        g2.draw(t2S2);
        g2.draw(t3S2);

        g2.draw(rightT);
    }

    /**
     * Returns the height of the frieze as an int
     * 
     * @return height of the frieze
     */
    public int getHeight()
    {
        return (int)this.height;
    }
}
