import info.gridworld.actor.Bug;
/**
 * Write a description of class DancingBug here.
 *
 * @author kittyk4t
 * @version 4 May 2018
 */
public class DancingBug extends Bug
{
    private int[] turns;
    private int indexTurn;
    public DancingBug( int[] numTurns)
    {
        this.turns=numTurns;
        this.indexTurn=0;
    }
    
    public void act()
    {
        for(int i=0; i<=this.turns[this.indexTurn]; i++)
        {
            this.turn();
        }
        this.indexTurn++;
        
        if(this.indexTurn>=this.turns.length)
        {
            this.indexTurn=0;
        }
        
        super.act();
    }
}
