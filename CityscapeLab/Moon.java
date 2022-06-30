
/**
 * Creates a moon, by creating two circles (ellipses)-one grey one dark blue-
 * that overlap each other to varying degress depending on the phase.
 *
 * @author kittyk4t
 * @version 3 October 2017
 */
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
public class Moon
{
    private int phase; //determines the overlap of the circles
    private int xPos; //upper left hand 'corner' x coorindate
    private int yPos; //upper left hand 'corner' y coorindate
    private int diameter; //diameter of both circles

    //RGB value from rapidtables.com
    private final Color sky= new Color(25,25,112);
    private final Color grey=new Color(220,220,220);
    /**
     * Constructor sets phase of moon to a default 0 (new moon), and default position
     */
    public Moon()
    {
        this.phase=0;
        this.xPos=75;
        this.yPos=50;
        this.diameter=125;
    }

    /**
     * Constructor sets phase to specified value 
     * 
     * @param numPhase value assigned to phase
     * @param xPos x-coorindate of uppermost left hand "corner" of moon
     * @param yPos y-coorindate of uppermost left hand "corner" of moon
     * @param size the diameter of the moon
     */
    public Moon(int numPhase, int x, int y, int size)
    {
        this.phase=numPhase;
        this.xPos=x;
        this.yPos=y;
        this.diameter=size;
    }

    /**
     * Creates a two circles, the moon and dark circle that changes the "phase" of the moon
     * 
     * @param g2 graphical context
     */

    public void draw(Graphics2D g2)
    {
        g2.setColor(grey);
        Ellipse2D.Double moon= new Ellipse2D.Double(xPos,yPos,diameter,diameter);
        g2.fill(moon);

        g2.setColor(sky);
        int position=phase*10+xPos;
        Ellipse2D.Double darkMoon=new Ellipse2D.Double(position,50,125,125);
        g2.fill(darkMoon);
    }
}
