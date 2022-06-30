import info.gridworld.actor.Bug;
/**
 * Write a description of class SpiralBug here.
 *
 * @author kittyk4t
 * @version 2 May 2018
 */
public class SpiralBug extends Bug
{
    int steps;
    int sideLength;

    public SpiralBug (int length)
    {
        this.steps = 0;
        this.sideLength = length;
    }
    
    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}
