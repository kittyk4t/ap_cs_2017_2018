import info.gridworld.actor.Bug;
/**
 * Write a description of class CircleBug here.
 *
 * @author kittyk4t
 * @version 2 May 2018
 */
public class CircleBug extends Bug
{
    private int steps;
    private int radius;

    /**
     * Constructs a circle bug that traces a circle of a given side length
     * @param length the side length
     */
    public CircleBug(int length)
    {
        steps = 0;
        radius = (int)(.5*length);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < radius && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}
