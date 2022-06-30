import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * The panel in which draws all of the shapes in the drawing editor
 * canvas shapes are drawn on
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class DrawingPanel extends JPanel
{
    Color fillColor; //current drawing color
    private ArrayList<DrawingShape> shapes; //array list of Drawing shape objects
    private DrawingShape active; //current active Drawingshape object
    private boolean selected; // whether or not ANY shape is selected
    private boolean stretch; //if a shape has been selected on the border (and therfore stretched)
    private Point2D.Double offSets; 
    //difference between active shape's center x and last mouse click's x and 
    //      difference between active shape's center y and last mouse click's y
    private Point2D.Double lastDrag; //last position of mouse while dragging/pressed down
    private MouseListener mouseListener;
    private MouseMotionListener motionListener;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        this.setBackground(Color.WHITE);
        this.active=null;
        this.fillColor= Color.BLUE;
        this.selected=true;
        this.stretch=false;
        this.offSets=null;
        this.lastDrag=null;
        this.mouseListener= new MouseListener()
        {

            public void mousePressed(MouseEvent event)
            {
                selected=false;
                stretch=false;
                offSets=new Point2D.Double(active.getCenter().getX()-event.getX(),
                    active.getCenter().getY()-event.getY());

                for(int i=shapes.size()-1; i>=0; i--)
                {
                    if(shapes.get(i).isOnBorder(new Point2D.Double(event.getX(),event.getY())))
                    {
                        active=shapes.get(i);
                        selected=true;
                        stretch=true;
                        i=-1;
                    }
                    else if(shapes.get(i).isInside(new Point2D.Double(event.getX(),event.getY())))
                    {
                        active=shapes.get(i);
                        selected=true;
                        i=-1;
                    }
                }
                repaint();
            }

            public void mouseReleased(MouseEvent event)          
            {
            }

            public void mouseClicked(MouseEvent event)          
            {
            }

            public void mouseEntered(MouseEvent event)          
            {
            }

            public void mouseExited(MouseEvent event)          
            {
            }
        };

        this.motionListener= new MouseMotionListener()
        {
            public void mouseDragged(MouseEvent event)
            {
                if(stretch)
                {
                    active.setRadius(active.getCenter().distance
                        (new Point2D.Double(event.getX(),event.getY())));
                }
                else if(selected)
                {

                    if(! event.equals(lastDrag))
                    {
                        active.move(event.getX()+offSets.getX(),event.getY()+offSets.getY());
                    }
                }
                repaint();
            }

            public void  mouseMoved(MouseEvent event)
            {
            }
        };

        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(motionListener);

        this.shapes= new ArrayList<DrawingShape> ();
    }

    /**
     * Invoked when the "Pick Color" button is clicked. Displays a JColorChooser and sets the
     *  selected color as the new fill color. Leaves the fill color unchanged if the user clicks
     *  "Cancel"
     *
     */
    public void pickColor()
    {
        Color selectedColor = 
            JColorChooser.showDialog( this, "select the fill color", this.fillColor );

        if( selectedColor != null )
        {
            this.fillColor = selectedColor;
        }
    }

    /**
     * Overrides JComponent’s getPreferredSize method 
     *      to return a size large enough to encapsulate a reasonable drawing canvas.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(800,800);
    }

    /**
     * Returns the current drawing color of this DrawingPanel object
     * 
     * @return fillColor's Color object
     */
    public Color getColor()
    {
        return this.fillColor;
    }

    /**
     *  
    Called from ControlPanel when the "Add Circle" button is clicked. 
    Adds a new square to the list. 
    The new circle has its center at the center of the drawing panel, 
    a random radius (within a range of 10-50-inclusive) and the current drawing color. 
    The new circle is designated as the “active shape.”
     */
    public void addCircle()
    {
        //sets center of shape to center of component
        double cenX=(this.getPreferredSize().getWidth())/2; 
        double cenY=(this.getPreferredSize().getHeight()/2);

        // sets radius to a random integer between 1-15 (inclusive)
        double r= (int)(Math.random()*50)+10;

        //adds new circle to list and sets it as the active shape
        this.shapes.add(new Circle(new Point2D.Double(cenX,cenY), r, this.getColor()));
        this.active=this.shapes.get(shapes.size()-1);
        this.repaint();
    }

    /**
     *  
    Called from ControlPanel when the "Add Square" button is clicked. 
    Adds a new square to the list. 
    The new square has its center at the center of the drawing panel, 
    a random radius (within a range of 10-50-inclusive) and the current drawing color. 
    The new square is designated as the “active shape.”
     */
    public void addSquare()
    {
        //sets center of shape to center of component
        double cenX=(this.getPreferredSize().getWidth())/2;
        double cenY=(this.getPreferredSize().getHeight()/2);

        // sets radius to a random integer between 1-15 (inclusive)
        double r= (int)(Math.random()*51)+10;

        //adds new square to list and sets it as the active shape
        this.shapes.add(new Square(new Point2D.Double(cenX,cenY), r, this.getColor()));
        this.active=this.shapes.get(shapes.size()-1);
        this.repaint();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2= (Graphics2D) g;
        super.paintComponent(g2);

        for(DrawingShape shape: this.shapes)
        {
            g2.setColor(shape.getColor());

            if(selected)
            {
                shape.draw(g2, !(shape==this.active));
            }
            else
            {
                shape.draw(g2, true);
            }
        }
    }

}
