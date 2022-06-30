import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
/**
 * Write a description of class ChameleonKid here.
 *
 * @author kittyk4t
 * @version 10 May 2018
 */
public class ChameleonKid extends ChameleonCritter
{
    public ArrayList<Actor> getActors()
    {
        Location loc1 =this.getLocation().getAdjacentLocation(this.getDirection()+Location.NORTH);
        Location loc2 =this.getLocation().getAdjacentLocation(this.getDirection()+Location.SOUTH);

        ArrayList<Actor> actors= new ArrayList<Actor>();

        if( getGrid().isValid(loc1) && getGrid().get(loc1) != null)
        {
            actors.add(getGrid().get(loc1));
        }
        
        if( getGrid().isValid(loc2) && getGrid().get(loc2) != null)
        {
            actors.add(getGrid().get(loc2));
        }
        
        return actors;
    }

}
