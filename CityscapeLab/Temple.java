
/**
 * Creates a Doric order temple
 *
 * @author kittyk4t
 * @version 4 October 2017
 */
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
public class Temple

{
    private int xPos; //x coorindate of tip of pediment
    private int yPos; //x coorindate of tip of pediment
    private int width; //width of pediment
    private double height; //height of pediment

    //RGB values from http://www.tayloredmktg.com/rgb/
    private final Color ivory=new Color(255,255,240);

    /**
     * Constructor Method intializes instance variable x,y, and w to specified values,
     *          this.height is intialized to 1/4 of the width
     */
    public Temple(int x, int y, int w)
    {
        this.xPos=x;
        this.yPos=y;
        this.width=w;
        this.height=width*.25;
    }

    //Got layout to make custom polygons 
    //from https://docs.oracle.com/javase/tutorial/2d/geometry/arbitrary.html
    /**
     * Creates the triangular shape that forms the pediment (top) of the temple
     * 
     * @return the pediment shape of the temple
     */
    public GeneralPath createPediment()
    {
        double x1Points[] = {xPos,xPos-(int)(width*.5),xPos+(int)(width*.5),xPos};
        double y1Points[] = {yPos,yPos+(int)height,yPos+(int)height,yPos};
        GeneralPath pediment = 
            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x1Points.length);
        pediment.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) 
        {
            pediment.lineTo(x1Points[index], y1Points[index]);
        }

        pediment.closePath();
        return pediment; 
    }

    /**
     * Creates a rectangle given the upper left x and y coorindate of the rectangle, and the width
     *              the height of the rectangel is 1/20 of the width
     *              
     *@ return rectangle that forms the base/stair (stylobate) of the temple
     */
    public Rectangle createStylobate(int x, int y, double w)
    {
        Rectangle stylobate= new Rectangle(x,y,(int)w,(int)(w*1/20));

        return stylobate; 
    }

    /**
     * Creates all aspects of the temple (frieze,columns,pediment and stylobate)
     * Draws some aspects in a black outline
     * Fills aspects as ivory shapes
     * 
     * @param g2 Graphical Context
     */
    public void draw(Graphics2D g2)
    {
        //creating objects from Freize and Column classes
        Frieze frieze=new Frieze(xPos-(int)(width*.5),yPos+(int)height,width);
        Column column1=new Column(xPos-(int)(width*.5),
                yPos+(int)height+(int)(frieze.getHeight()*1.75),
                (int)(height*1.75));

        Column column2=new Column(xPos-(int)(width*1/30),
                yPos+(int)height+(int)(frieze.getHeight()*1.75),
                (int)(height*1.75));

        Column column3=new Column(xPos+(int)(width*.39),
                yPos+(int)height+(int)(frieze.getHeight()*1.75),
                (int)(height*1.75));

        //drawing objects
        column1.draw(g2);
        column2.draw(g2);
        column3.draw(g2);
        frieze.draw(g2);

        //drawig black outline of bottom stair (must be done so eveyrthing overlaps nicely)
        g2.setColor(Color.BLACK);
        g2.draw(createStylobate(xPos-(int)(width*4/5)+(int)(width*1/7),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight()+(int)(width*1/10),
                width+(int)(width*2/7)));

        //fills all objects in ivory
        g2.setColor(ivory);
        g2.fill(createPediment());

        //calls method that creates top stair and then fills it
        g2.fill(createStylobate(xPos-(int)(width*1/2)-(int)(width*1/20),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight(),
                width+(int)(width*1/15)));

        //calls method that creates middle stair and then fills it
        g2.fill(createStylobate(xPos-(int)(width*3/5),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight()+(int)(width*1/20),
                width+(int)(width*1/6))); 

        //calls method that creates bottom stair and then fills it
        g2.fill(createStylobate(xPos-(int)(width*4/5)+(int)(width*1/7),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight()+(int)(width*1/10),
                width+(int)(width*2/7)));

        //draws black oultine for remaining stylobates
        g2.setColor(Color.BLACK);

        g2.draw(createStylobate(xPos-(int)(width*1/2)-(int)(width*1/20),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight(),
                width+(int)(width*1/15)));

        g2.draw(createStylobate(xPos-(int)(width*3/5),
                yPos+(int)height+(int)frieze.getHeight()+(int)column1.getHeight()+(int)(width*1/20),
                width+(int)(width*1/6))); 

    }
}
