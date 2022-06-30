
/**
 * Creates a eight pointed star by combining multiple custom polygons
 *
 *@author kittyk4t
 *@version 3 October 2017
 */
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
public class Star
{
    private double xCen; // x coorindate of center of  star
    private double yCen; //y coorindate of center of star
    private double segLength; //length of any one side of the star
    private boolean status; // determines which order the colors of the star appear 

    //RGB values from rapidtables.com
    private final Color gold= new Color(212,175,55);
    private final Color blueGrey=new Color(173,216,230);

    /**
     * Creates a circle that will form the base of the star,initalizes all instance variables
     *      
     *@param x the x coorindate of the upper right hand corner of the circle
     *@param y the y coorindate of the upper right hand corner of the circle
     *@param diameter the diameter for the circle
     */
    public Star(double x, double y, int diameter)
    {
        Ellipse2D.Double base=new Ellipse2D.Double(x,y,diameter,diameter);
        this.xCen=base.getCenterX();
        this.yCen=base.getCenterY();
        this.segLength=diameter*.5;
        this.status=true;
    }

    /**
     * Creates a circle that will form the base of the star,initalizes all instance variables
     *      
     *@param x the x coorindate of the upper right hand corner of the circle
     *@param y the y coorindate of the upper right hand corner of the circle
     *@param diameter the diameter for the circle
     *@param stat the begining status of this star object
     */
    public Star(double x, double y, int diameter, boolean stat)
    {
        Ellipse2D.Double base=new Ellipse2D.Double(x,y,diameter,diameter);
        this.xCen=base.getCenterX();
        this.yCen=base.getCenterY();
        this.segLength=diameter*.5;
        this.status=stat;
    }

    //Got layout to make custom polygons (i.e. all the shapes except the ellipse to make the star):
    //from https://docs.oracle.com/javase/tutorial/2d/geometry/arbitrary.html 
    /**
     * Creates a diamond, whose width is greater than its height, 
     * 
     * @return frontDiamondH diamond shape that forms forms side points of the star
     */
    public GeneralPath createHorizontalDiamond()
    {
        double x1Points[] = {xCen, xCen-(segLength*2), xCen, xCen+(segLength*2)};
        double y1Points[] = {yCen-segLength, yCen, yCen+segLength,yCen};
        GeneralPath frontDiamondH = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length); 
        frontDiamondH.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            frontDiamondH.lineTo(x1Points[index], y1Points[index]);
        }

        frontDiamondH.closePath();
        return frontDiamondH;
    }

    /**
     * Creates a diamond, whose height is greater than its width, 
     * 
     * @return frontDiamondV diamond shape that forms forms top and bottom points of the star 
     */
    public GeneralPath createVerticalDiamond()
    {
        double x2Points[] = {xCen,xCen-segLength, xCen, xCen+segLength};
        double y2Points[] = {yCen-(segLength*2), yCen, yCen+(segLength*2), yCen};
        GeneralPath frontDiamondV = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x2Points.length);
        frontDiamondV.moveTo(x2Points[0], y2Points[0]);

        for (int index = 1; index < x2Points.length; index++) 
        {
            frontDiamondV.lineTo(x2Points[index], y2Points[index]);
        }

        frontDiamondV.closePath();
        return frontDiamondV;
    }

    /**
     * Creates a kite that stems from the center of the star
     * 
     * @return nWKite A kite that forms the North West point of the star
     */
    public GeneralPath createNorthWestPt()
    {
        double x1Points[] = {xCen,xCen, xCen-(segLength*1.5), xCen-segLength,xCen};
        double y1Points[] = {yCen,yCen-segLength, yCen-(segLength*1.5),yCen,yCen};
        GeneralPath nWKite = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length);
        nWKite.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            nWKite.lineTo(x1Points[index], y1Points[index]);
        }

        nWKite.closePath();
        return nWKite;
    }

    /**
     * Creates a kite that stems from the center of the star
     * 
     * @return nEKite A kite that forms the North East point of the star
     */
    public GeneralPath createNorthEastPt()
    {

        double x1Points[] = {xCen,xCen, xCen+(segLength*1.5), xCen+segLength,xCen};
        double y1Points[] = {yCen,yCen-segLength, yCen-(segLength*1.5),yCen,yCen};
        GeneralPath nEKite = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length);
        nEKite.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            nEKite.lineTo(x1Points[index], y1Points[index]);
        }

        nEKite.closePath();
        return nEKite;
    }

    /**
     * Creates a kite that stems from the center of the star
     * 
     * @return sWKite A kite that forms the South West point of the star
     */
    public GeneralPath createSouthWestPt()
    {
        double x1Points[] = {xCen,xCen, xCen-(segLength*1.5), xCen-segLength,xCen};
        double y1Points[] = {yCen,yCen+segLength, yCen+(segLength*1.5),yCen,yCen};
        GeneralPath sWKite = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length);
        sWKite.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            sWKite.lineTo(x1Points[index], y1Points[index]);
        }

        sWKite.closePath();
        return sWKite;
    }

    /**
     * Creates a kite that stems from the center of the star
     * 
     * @return sEKite A kite that forms the South East point of the star
     */
    public GeneralPath createSouthEastPt()
    {

        double x1Points[] = {xCen,xCen, xCen+(segLength*1.5), xCen+segLength,xCen};
        double y1Points[] = {yCen,yCen+segLength, yCen+(segLength*1.5),yCen,yCen};
        GeneralPath sEKite = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length);
        sEKite.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            sEKite.lineTo(x1Points[index], y1Points[index]);
        }

        sEKite.closePath();
        return sEKite;
    }

    /**
     * Fills four front points in gold and back four points blueGrey
     * 
     * @param g2 Graphical context
     */
    public void draw1(Graphics2D g2)
    {
        //fills four kites that form the back four points in blueGrey
        g2.setColor(blueGrey);
        g2.fill(createNorthWestPt());
        g2.fill(createNorthEastPt());
        g2.fill(createSouthWestPt());
        g2.fill(createSouthEastPt());

        //fills two diamonds that form the front four points in gold
        g2.setColor(gold);
        g2.fill(createHorizontalDiamond());
        g2.fill(createVerticalDiamond());
    }

    /**
     *Fills four front points in blueGrey and back four points gold
     * 
     * @param g2 Graphical context
     */
    public void draw2(Graphics2D g2)
    {
        //fills four kites that form the back four points in gold
        g2.setColor(gold);
        g2.fill(createNorthWestPt());
        g2.fill(createNorthEastPt());
        g2.fill(createSouthWestPt());
        g2.fill(createSouthEastPt());

        //fills two diamonds that form the front four points in blueGrey
        g2.setColor(blueGrey);
        g2.fill(createHorizontalDiamond());
        g2.fill(createVerticalDiamond());
    }

    /**
     * Checks status of star, and calls corresponding draw method (draw1=true, draw2=false)
     * 
     * @param g2 Graphical context
     */
    public void twinkle(Graphics2D g2)
    {
        if (this.getStatus())
        {
            this.draw1(g2);
        }
        else
        {
            this.draw2(g2);
        }
    }

    /**
     * Changes status from true to false or vice versa;
     *      status refers to the order in which the colors of the star appear (background vs forground)
     */

    public void setStatus()
    {
        if (status) 
        {
            status=false;
        }
        else
        {
            status=true;
        }
    }

    /**
     * Returns status variable
     * 
     * @return status boolean value that determines how the colors of the star appear 
     *      (u.e. background vs forground)
     */
    public boolean getStatus()
    {
        return status;
    }
}

