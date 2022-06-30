import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
/**
 * Write a description of class DancingBugRunner here.
 *
 * @author kittyk4t
 * @version 4 May 2018
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] numTurns= {2,4,1,3};
        DancingBug alice = new DancingBug(numTurns);
        alice.setColor(Color.ORANGE);

        world.add(new Location(5, 5), alice);

        world.show();
    }

    public static void test()
    {
        ActorWorld world = new ActorWorld();
        int[] numTurns= {2,4,1,3};
        DancingBug alice = new DancingBug(numTurns);
        alice.setColor(Color.ORANGE);

        world.add(new Location(5, 5), alice);
        world.show();
    }
}
