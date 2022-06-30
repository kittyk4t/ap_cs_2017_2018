import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Abstract class, implements a shape object with a center point, radius and color
 *
 * @author kittyk4t
 * @version 27 Febuary 2018
 */
public abstract class DrawingShape
{
    private Point2D.Double center;
    private double radius;
    private Color color;

    /**
     * Creates a shape with the center at the specified point
     *                  and with the specified radius and color.   
     *@param cen, specified center point
     *@param r, specifed radius of this shape
     *@param col, specified color of this shape
     */
    DrawingShape(Point2D.Double cen, double r, Color col)
    {
        this.center=cen;
        this.radius=r;
        this.color=col;
    }

    /**
     * Returns the the center of the shape.
     * 
     * @return center of this DrawingShape object
     */
    public Point2D.Double getCenter()
    {
        return this.center;
    }

    /**
     * Returns the the center of the shape.
     * 
     * @return radius of this DrawingShape object
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Returns the the color of the shape.
     * 
     * @return color of this DrawingShape object
     */
    public Color getColor()
    {
        return this.color;
    }

    /**
     * Sets the center of the shape to the specified x and y values.
     * 
     * @param x the specifed x value of the new center
     * @param y the specifed y value of the new center
     */
    public void move(double x, double y)
    {
        this.center=new Point2D.Double(x,y);
    }
    
    /**
     * Sets the radius of this shape to r.  
     * 
     * @param r new specified radius 
     */
    public void setRadius(double r)
    {
        this.radius=r;
    }
    
   
    
    /**
     * Returns true if the point lies inside this shape, false otherwise. 
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point is within this DrawingShape object
     */
    public abstract boolean isInside (Point2D.Double point);
    
    /**
     * Returns true if the point lies approximately on the border of this shape, 
     *          false otherwise.
     * 
     * @param point specified point
     * 
     * @return true/false based on if the specifed point aproximately
     * this DrawingShape object
     */
    public abstract boolean isOnBorder(Point2D.Double point);
    
    /**
     * Draws this shape. Draws a filled shape if filled is true,
     *              and a hollow shape otherwise.
     * @param g2 Graphics 2D object
     * @param filled filled state of this DrawingShape object
     */
    public abstract void draw(Graphics2D g2,boolean filled);
}
