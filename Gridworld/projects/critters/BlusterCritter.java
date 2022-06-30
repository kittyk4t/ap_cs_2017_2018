import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
/**
 * Write a description of class BlusterCritter here.
 *
 * @author kittyk4t
 * @version 14 May 2018
 */
public class BlusterCritter extends Critter
{
    private int c;

    public BlusterCritter()
    {
        super();
        this.c=1;
    }

    public BlusterCritter(int courage)
    {
        super();
        this.c=courage;
        this.setColor(Color.PINK);
    }

    // public ArrayList<Actor> getActors()
    // {
        // ArrayList<Actor> actors= new ArrayList<Actor>();

        // for(int i=0; i<this.getGrid().getNumRows(); i++)
        // {
            // for(int j=0; j<this.getGrid().getNumCols(); j++)
            // {
                // if(i>= (this.getLocation().getRow()-2) && i<= (this.getLocation().getRow()+2))
                // {
                    // if(j>= (this.getLocation().getCol()-2) && j<= (this.getLocation().getCol()+2))
                    // {
                        // Location loc= new Location (i, j);
                        // if( getGrid().isValid(loc) && getGrid().get(loc) != null)
                        // {
                            // actors.add(getGrid().get(loc));
                        // }
                    // }
                // }
            // }
        // }
        // return actors;
    // }

    public void processActors(ArrayList<Actor> actors)
    {
        if(actors.size()<this.c)
        {
            setColor(this.getColor().brighter());
             
            return;
        }
        setColor(this.getColor().darker());   
    }
}
