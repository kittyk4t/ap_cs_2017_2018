

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ColorManipulatorTest.
 *
 * @author  kittyk4t
 * @version 8 November 2017
 */
public class ColorManipulatorTest
{
    /**
     * Default constructor for test class ColorManipulatorTest
     */
    public ColorManipulatorTest()
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
    
    @Test
    public void testSetGrayScale()
    {
        Picture picture= new Picture( "IMG_5613.jpg" );
        ColorManipulator testManipulator = new ColorManipulator( picture );
        
        //calculates expected grey values of pixels (0,0),(200,50) and (550,400)
        int ave1=(testManipulator.getRedValue(0,0)+
                    testManipulator.getGreenValue(0,0)
                    +testManipulator.getBlueValue(0,0))/3;
        int ave2=(testManipulator.getRedValue(200,50)+
                    testManipulator.getGreenValue(200,50)
                    +testManipulator.getBlueValue(200,50))/3;
        int ave3=(testManipulator.getRedValue(550,400)+
                    testManipulator.getGreenValue(550,400)
                    +testManipulator.getBlueValue(550,400))/3;
                    
        //set picture to grey scale
        testManipulator.setGrayScale();
        
        //tests pixel (0,0)
        assertEquals(ave1,testManipulator.getRedValue(0,0));
        assertEquals(ave1,testManipulator.getGreenValue(0,0));
        assertEquals(ave1,testManipulator.getBlueValue(0,0));
        
        //tests pixel (200,50)
        assertEquals(ave2,testManipulator.getRedValue(200,50));
        assertEquals(ave2,testManipulator.getGreenValue(200,50));
        assertEquals(ave2,testManipulator.getBlueValue(200,50));

        //tests pixel (550,400)
        assertEquals(ave3,testManipulator.getRedValue(550,400));
        assertEquals(ave3,testManipulator.getGreenValue(550,400));
        assertEquals(ave3,testManipulator.getBlueValue(550,400));
    }
}
