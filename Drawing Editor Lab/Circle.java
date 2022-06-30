import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
/**
 * Shape object sublcass of the abstract class DrawingShape
 *
 * @author kittyk4t
 * @version 27 Febuary 2018
 */
public class Circle extends DrawingShape
{
    private double diameter; //overall height/width of circle object

    /**
     * @param cen specified center point of this circle object
     * @param r specified radius of this circle object 
     * @param col specified color of this circle object
     */
    public Circle(Point2D.Double cen, double r, Color col)
    {
        super(cen,r,col); //calls super class's constructor
        this.diameter=r*2; //set diameter to twice the radius
    }

    /**
     * Creates and returns circle shape reflecting current state of all instance variables
     * 
     * @return circle shape with correct dimensions and location
     */
    public Ellipse2D createCircle()
    {
        return new Ellipse2D.Double(super.getCenter().getX()-super.getRadius(),
            super.getCenter().getY()-super.getRadius(), this.diameter, this.diameter);
    }

    /**
     * Sets the radius of this shape to new specifed value.
     * Readjusts this Circle object's sizing accordingly 
     * 
     * @param r new specified radius 
     */
    public void setRadius(double r)
    {
        super.setRadius(r);
        this.diameter=r*2; //updates diameter
    }

    /**
     * Returns true if the point lies inside this shape, false otherwise. 
     * The point lies on the border of this Circle, 
     *  if the distance between the point and the center is less than or equal to the radius
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point is within this DrawingShape object
     */
    public boolean isInside (Point2D.Double point)
    {
        return super.getCenter().distance(point)<=super.getRadius();
    }

    /**
     * Returns true if the point lies approximately on the border of this shape, 
     *          false otherwise.
     * The point lies on the border of this Circle, 
     *  if the difference of the distance between the point and the center is less than
     *      the 1/4 of the radius
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point aproximately
     * this DrawingShape object
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        return Math.abs((super.getCenter().distance(point)-super.getRadius()))<(super.getRadius()*.25);
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
            g2.fill(this.createCircle());
        }
        else
        {
            g2.draw(this.createCircle());   
        }
    }
}
