import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * Shape object sublcass of the abstract class DrawingShape
 *
 * @author kittyk4t
 * @version 27 Febuary 2018
 */
public class Square extends DrawingShape
{
    private int sideLength; // total side length- twice the radius

    /**
     * Contructs Square object with specifed center, radius/side length and color
     * 
     * @param cen specified center point of this square object
     * @param r specified radius of this square object (half of total side length)
     * @param col specified color of this square object
     */
    public Square(Point2D.Double cen, double r, Color col)
    {
        super(cen,r,col); //calls super class's constructor
        this.sideLength=(int)(super.getRadius()*2);           
    }

    /**
     * Creates and returns square shape reflecting current state of all instance variables
     * 
     * @return square shape with correct dimensions and location
     */
    public Rectangle createSquare()
    {
        return new Rectangle((int)(super.getCenter().getX()-super.getRadius()),
            (int)(super.getCenter().getY()-super.getRadius()),
            sideLength,sideLength);
    }

    /**
     * Sets the radius of the shape to the specified new value.
     * Readjusts this square object's sizing accordingly 
     */
    public void setRadius(double r)
    {
        super.setRadius(r); //sets radius
        this.sideLength=(int)(super.getRadius()*2); //sets sideLength
    }

    /**
     * Returns true if the point lies inside this square, false otherwise.
     * A point is within the point if the fully contained within the area
     *      or on the border of this square object
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point is within this Square object
     */
    public boolean isInside (Point2D.Double point)
    {
        if( super.getCenter().getX()-super.getRadius()<= point.getX() &&
        point.getX()<=super.getCenter().getX()+super.getRadius())
        {
            if(super.getCenter().getY()-super.getRadius()<= point.getY() &&
            point.getY()<=super.getCenter().getY()+super.getRadius())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the point lies approximately on the border of this Square object, 
     *          false otherwise.
     *          
     *The point is on the border if the difference of the 
     *      distance between the point and the center of this square object
     *      is less than 1/8 of the length of the diagonal (radius^1/2) 
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point aproximately
     * this Square object
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        return Math.abs(((super.getCenter().distance(point)-(super.getRadius()*Math.sqrt(2)))))
                                    <(((super.getRadius()*Math.sqrt(2))*.125));
    }

    /**
     * Draws this shape. Draws a filled shape if filled is true,
     *              and a hollow shape otherwise.
     * @param g2 Graphics 2D object
     * @param filled filled state of this DrawingShape object
     */
    public void draw(Graphics2D g2,boolean filled)
    {
        if(filled)
        {
            g2.fill(this.createSquare());
        }
        else
        {
            g2.draw(this.createSquare());   
        }
    }
}
