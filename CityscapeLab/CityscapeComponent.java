import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.Color;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author kittyk4t
 * @version 3 October 2017
 */
public class CityscapeComponent extends JPanel
{
    // define the objects in your Cityscape as instance variables
    // ...
    private Moon moon;
    private Hill hill;
    private Temple temple;

    //Canis Minor Stars:
    private Star procyon;
    private Star gomeisa;
    private Star yCmi;
    private Star eCmi;

    //Canis Major Stars:
    private Star sirius;
    private Star adhara;
    private Star wezen;
    private Star mirzam;
    private Star aludra;
    private Star o2Cma; 

    //RGB value from rapidtables.com
    private final Color sky= new Color(25,25,112);

    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    /**
     * Constructor method of CityscapeComponent, intializes all instance variables
     */
    public CityscapeComponent()
    {
        Random rand= new Random();
        moon=new Moon(rand.nextInt(7),75,50,125);
        temple=new Temple(400,350,325);
        hill=new Hill(0,550,1200,300);

        //Canis Minor stars
        procyon= new Star(885,230,25,rand.nextBoolean());
        gomeisa= new Star(1025,125,20,rand.nextBoolean());
        yCmi= new Star(1020,40,15,rand.nextBoolean());
        eCmi= new Star(1105,30,12,rand.nextBoolean());

        //Canis Major stars
        sirius= new Star(550,50,30,rand.nextBoolean());
        mirzam= new Star(700,120,20,rand.nextBoolean());
        wezen= new Star(425,230,20,rand.nextBoolean());
        adhara= new Star(500,290,20,rand.nextBoolean());
        aludra= new Star(310,300,15,rand.nextBoolean());
        o2Cma= new Star(425,140,12,rand.nextBoolean());

        this.setBackground(sky); 
    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // invoke the draw method on each object in your Cityscape
        // ...
        moon.draw(g2);
        hill.draw(g2);
        temple.draw(g2);

        //Canis Minor stars
        procyon.twinkle(g2);
        gomeisa.twinkle(g2);
        yCmi.twinkle(g2);
        eCmi.twinkle(g2);

        //Canis Major stars
        sirius.twinkle(g2);
        mirzam.twinkle(g2);
        wezen.twinkle(g2);
        adhara.twinkle(g2);
        aludra.twinkle(g2);
        o2Cma.twinkle(g2);
    }

    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...

        //Canis Minor stars
        procyon.setStatus();
        gomeisa.setStatus();
        yCmi.setStatus();
        eCmi.setStatus();

        //Canis Major stars
        sirius.setStatus();
        mirzam.setStatus();
        wezen.setStatus();
        adhara.setStatus();
        aludra.setStatus();
        o2Cma.setStatus();

        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
