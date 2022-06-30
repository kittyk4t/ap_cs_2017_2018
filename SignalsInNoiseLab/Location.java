
/**
 * Write a description of class Location here.
 *
 * @author kittyk4t
 * @version 12 December 2017
 */
public class Location
{
    private int row;
    private int col;
    
    /**
     * Constructor method, assigns specified values for row and col of Location to variables row and col
     * 
     * @param r the specified row for this Location object
     * @param c the specified column for this Location object
     * 
     */
    public Location(int r, int c)
    {
        this.row=r;
        this.col=c;
    }
    
    /**
     * Returns the row of the Location object
     * 
     * @return row the row of this Location object
     */
    public int getRow()
    {
        return this.row;
    }
    
    /**
     * Returns the column of the Location object
     * 
     * @return col the column of this Location object
     */
    public int getCol()
    {
        return this.col;
    }
}
