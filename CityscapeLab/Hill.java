
/**
 * Creates a shape resembling the top slope of a hill
 *
 * @author kittyk4t
 * @version 9 October 2017
 */
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Hill
{
    private int xPos; //x coorindate of upper left hand "corner" of ellipse (slope of hill)
    private int yPos; //y coorindate of upper left hand "corner" of ellipse (slope of hill)
    private int width; //width of ellipse of the hill
    private int height; //height of ellipse of the hill
    //RGB values from rapidtables.com
    private final Color green= new Color(0,100,0);

    /**
     * Constructor method, intializes all instance variables to specified amounts
     * 
     * @param x x-coorindate of upper left corner of ellipse
     * @param y y-coorindate of upper left corner of ellipse
     * @param w width of ellipse
     * @param h hieght of ellipse
     */
    public Hill(int x, int y, int w, int h)
    {
        this.xPos=x;
        this.yPos=y;
        this.width=w;
        this.height=h;
    }

    /**
     * Creates and fills a rectangle and ellipse that together form a hill
     * 
     * @param g2 Graphical Context
     */
    public void draw(Graphics2D g2)
    {
        Rectangle base=new Rectangle(xPos,yPos+(int)(height*.5),width,height);
        Ellipse2D.Double slope= new Ellipse2D.Double(xPos,yPos,width,height);

        g2.setColor(green);
        g2.fill(base);
        g2.fill(slope);
    }

}
