/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /** Method to test mirrorVerticalRightToLeft */
    public static void testMirrorVerticalRightToLeft()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    /** Method to test mirrorHorizontal*/
    public static void testMirrorHorizontal()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontal();
        caterpillar.explore();
    }

    /** Method to test mirrorHorizontal*/
    public static void testMirrorHorizontalBotToTop()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontalBotToTop();
        caterpillar.explore();
    }
    
    /** Method to test mirrorHorizontal*/
    public static void testMirrorDiagonal()
    {
        Picture butterfly = new Picture("butterfly1.jpg");
        butterfly.explore();
        butterfly.mirrorDiagonal();
        butterfly.explore();
    }
    
    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /** Method to test mirrorArms */
    public static void testMirrorArms()
    {
        Picture snowMan = new Picture("snowman.jpg");
        snowMan.explore();
        snowMan.mirrorArms();
        snowMan.explore();
    }
    
    /** Method to test mirrorGull */
    public static void testMirrorGull()
    {
        Picture gull = new Picture("seagull.jpg");
        gull.explore();
        gull.mirrorGull();
        gull.explore();
    }
    
    /** test keepOnlyBlue method */
    public static void testKeepOnlyBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }
    
    /** test negate method */
    public static void testNegate()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }
    
    /** test fixWater method */
    public static void testFixWater()
    {
        Picture water = new Picture("water.jpg");
        water.explore();
        water.fixWater();
        water.explore();
    }
    
    /** Method to test convertSepia method */
    public static void testConvertSepia()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.convertSepia();
        beach.explore();
    }
    
    /** Method to test scaleByHalf method */
    public static void testScaleByHalf()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        Picture smallBeach= beach.scaleByHalf();
        smallBeach.explore();
    }
    
    /** Method to test scaleToSize() */
    public static void testScaleToSize()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        Picture smallBeach= beach.scaleToSize(80,350);
        smallBeach.explore();
    }
    
    /** Method to test crop and copy method */
    public static void testCropAndCopy()
    {
        Picture beach = new Picture("beach.jpg");
        Picture butterfly = new Picture("butterfly1.jpg");
        
        beach.cropAndCopy(butterfly,150,300,30,230,24,12);
        beach.explore();
    }
    
    /** Method to test the collage method */
    public static void testCollage()
    {
        Picture canvas = new Picture(590,605);
        
        canvas.createCollage();
        canvas.explore();
        
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}