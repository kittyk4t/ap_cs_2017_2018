

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class RadarTest here.
 * 
 * @author kittyk4t
 * @version 12 December 2017
 */
public class RadarTest
{
    /**
     * Default constructor for objects of class RadarTest
     */
    public RadarTest()
    {
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void testRadar() //only ONE test method, tests entire class, maybe make more than one case
    {
        // test that the Radar class successfully finds the location of the monster after several scans
        
        Radar testRadar1= new Radar(100,100);
        Radar testRadar2= new Radar(100,100);
        Radar testRadar3= new Radar(100,100,true);
        
        //test #1
        Location monsterLoc= new Location(15,10);
        testRadar1.setMonsterLocation(monsterLoc);
        
        for(int i=0; i<=10; i++)
        {
            testRadar1.scan();
        }
       
        Location posMonster =testRadar1.findMonster();
        
        assertEquals(posMonster.getRow(),monsterLoc.getRow()); //sees if rows of monsterLoc and posMonster match
        assertEquals(posMonster.getCol(),monsterLoc.getCol()); //sees if columns of monsterLoc and posMonster match
        
        //test #2
        Location monsterLoc2= new Location(1,0);
        testRadar2.setMonsterLocation(monsterLoc2);
        
        for(int i=0; i<=10; i++)
        {
            testRadar2.scan();
        }
       
        posMonster =testRadar2.findMonster();
        
        assertEquals(posMonster.getRow(),monsterLoc2.getRow()); //sees if rows of monsterLoc and posMonster match
        assertEquals(posMonster.getCol(),monsterLoc2.getCol()); //sees if columns of monsterLoc and posMonster match
        
        //test #3
        Location monsterLoc3= new Location(99,27);
        testRadar3.setMonsterLocation(monsterLoc3);
        
        
        for(int i=0; i<=10; i++)
        {
            testRadar3.scan();
        }

        posMonster =testRadar3.findMonster();
        
        assertEquals(posMonster.getRow(),monsterLoc3.getRow()); //sees if rows of monsterLoc and posMonster match
        assertEquals(posMonster.getCol(),monsterLoc3.getCol()); //sees if columns of monsterLoc and posMonster match
        
        
    }
}
