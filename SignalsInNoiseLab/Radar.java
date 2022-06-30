
/**
 * The model for radar scan and accumulator
 * 
 * @author kittyk4t
 * @version 12 December 2017
 */
public class Radar
{

    // stores whether each cell triggered detection for the current scan of the radar
    // (true represents a detected monster, which may be a false positive)
    private boolean[][] currentScan;

    // value of each cell is incremented for each scan in which that cell triggers detection
    private int[][] accumulator; //2D tally sheet

    // location of the monsters
    private Location monsterLocation;
    private Location monsterLocation2=null;
    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;

    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar-automatcially creates 1 monster location
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        this(rows,cols,false);
    }

    /**
     * Constructor for objects of class Radar-allows for 2 monsters
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     * @param multMonsters if true creates 2 monster locations, false only 1 location
     */
    public Radar(int rows, int cols, boolean multMonsters)
    {
        // initialize the currentScan 2D array and the accumulator 2D array

        this.currentScan=new boolean[rows][cols];
        this.accumulator=new int[rows][cols];

        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method for the unit test
        int row = (int)(Math.random() * rows);
        int col = (int)(Math.random() * cols);
        this.monsterLocation = new Location(row,col);

        if(multMonsters)
        {
            row = (int)(Math.random() * rows);
            col = (int)(Math.random() * cols);
            this.monsterLocation2 = new Location(row,col);
        }
        this.noiseFraction = 0.05;
        this.numScans= 0;
    }

    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        // algorithm for performing a scan:
        //    1. set all cells in the currentScan 2D array to false
        //    2. set the location of the monster in the currentScan 2D array
        //    3. inject noise into the grid by invoking the injectNoise method
        //    4. update the accumulator 2D array based on the state of the currentScan 2D array
        //    5. increment the numScans instance variable

        for(int i=0; i<this.currentScan.length; i++)
        {
            for(int j=0; j<this.currentScan[i].length; j++)
            {
                this.currentScan[i][j]=false; //step 1
            }
        }

        this.currentScan[monsterLocation.getRow()][monsterLocation.getCol()]=true; //step 2
        
        if(monsterLocation2!=null)
        {
            this.currentScan[monsterLocation2.getRow()][monsterLocation2.getCol()]=true; 
        }
        
        this.injectNoise(); //step 3

        for(int i=0; i<this.accumulator.length; i++)
        {
            for(int j=0; j<this.accumulator[i].length; j++)
            {
                if(this.currentScan[i][j])
                {
                    this.accumulator[i][j]++; //step 4
                }
            }
        }

        this.numScans++; //step 5
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row  the row in which the monster is located
     * @param   col  the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(Location loc)
    {
        // remember the monster's location
        this.monsterLocation = loc;

        // update the radar grid to show that something was detected at the specified location
        currentScan[ this.monsterLocation.getRow() ][ this.monsterLocation.getCol() ] = true;
    }

    /**
     * Sets the location of the second monster
     * 
     * @param   row  the row in which the monster is located
     * @param   col  the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation2(Location loc)
    {
        // remember the monster's location
        this.monsterLocation2 = loc;

        // update the radar grid to show that something was detected at the specified location
        currentScan[ this.monsterLocation2.getRow() ][ this.monsterLocation2.getCol() ] = true;
    }
    
    /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        this.noiseFraction = fraction;
    }

    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(Location loc)
    {
        return this.currentScan[ loc.getRow() ][ loc.getCol() ];
    }

    /**
     * Returns a Location object containing the row and column of the detected monster based on analyzing the
     *  accumulator (not based on the monsterLocationRow and monsterLocationCol instance variables).
     * 
     * @return the location of the detected monster 
     */
    public Location findMonster() //based on acculmulator
    {
        Location likelyLocation=this.findMonsters()[0];
        return likelyLocation;
    }

    /**
     * Returns a Location array containing the Location objects of the detected monsters based on analyzing the
     *  accumulator (not based on the monsterLocationRow and monsterLocationCol instance variables).
     * 
     * @return the locations of the detected monsters
     */
    public Location[] findMonsters()
    {
        
        int maxR=0; //row of cell containing the highest likelyhood of containing the monster
        int maxC=0; //column of cell containing the highest likelyhood of containing the monster

        int nextMaxR=0; //row of cell containing the 2nd highest likelyhood of containing a monster (finds 2nd monster)
        int nextMaxC=0; //column of cell containing the 2nd highest likelyhood of containing a monster (finds 2nd monster)
        
        for(int i=0; i<this.accumulator.length; i++)
        {
            for(int j=0; j<this.accumulator[i].length; j++)
            {
                if(this.accumulator[maxR][maxC]<=this.accumulator[i][j])
                {
                    nextMaxR=maxR;
                    nextMaxC=maxC;
                    maxR=i;
                    maxC=j;
                }
            }
        }

        Location[] likelyLocations= {new Location(maxR, maxC), new Location(nextMaxR, nextMaxC)};
        return likelyLocations;
    }
    
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(Location loc)
    {
        return accumulator[ loc.getRow() ][ loc.getCol() ];
    }

    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }

    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }

    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }

    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise() //exactly match for full credit
    {
        // Iterate through all cells in the currentScan 2D array to inject noise by setting false positives
        // (detected monster where is there none) or false negatives (missed detection of a monster where is one).
        // The noiseFraction instance variable is the probability that a given cell will be
        // detected as a false positive or false negative. You must handle the cell containing the monster as a
        // special case since, if noise is being injected into that cell, that is a false negative and the cell must
        // be set to false.

        int prob; //amount that determines if a given cell will be detected as a false positive/negative
        for(int i=0; i<this.currentScan.length; i++) 
        {
            for(int j=0; j<this.currentScan[i].length; j++)
            {
                if(Math.random()<=noiseFraction)
                {
                    if(this.currentScan[i][j]) 
                    
                    {
                        this.currentScan[i][j]=false; //sets a false negative
                    }
                    else
                    {
                        this.currentScan[i][j]=true; //sets a false positive
                    }
                }

            }
        }
    }

}

