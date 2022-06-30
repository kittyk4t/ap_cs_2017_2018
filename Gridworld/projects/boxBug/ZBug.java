import info.gridworld.actor.Bug;
/**
 * Write a description of class ZBug here.
 *
 * @author kittyk4t
 * @version 2 May 2018
 */
public class ZBug extends Bug
{
    private int sideLength;
    private int steps;
    private int turns;
    private boolean complete;

    public ZBug( int length)
    {
        this.turn();
        this.turn();
        this.complete=false;
        this.sideLength=length;
        this.steps=0;
        this.turns=0;

    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove() && !complete)
        {
            move();
            steps++;
        }
        else
        {
            if(turns==0)
            { 
                turn();
                turn();
                turn();
                turns++;
                steps = 0;
            }
            else if(turns==1)
            {
                turn();
                turn();
                turn();
                turn();
                turn();
                turns++;
                steps=0;
            }
            else if(turns>=2)
            {
                complete=true;
            }
        }
    }
}
