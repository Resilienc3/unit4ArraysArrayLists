import java.util.Scanner;
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit @Jalen Smith
 * @version 12 December 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;
    
    //maximum difference in the x value
    private int maxdx = 5;
    
    //maximum difference in the y value
    private int maxdy = 5;
    
    //actual difference in the x value
    private int dx;
    
    //actual difference in the y value
    private int dy;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        accumulator = new int[rows][cols]; // elements will be set to 0
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = (int)(Math.random() * rows);
        monsterLocationCol = (int)(Math.random() * cols);
        
        noiseFraction = 0.1;
        numScans= 0;
        
        //set dx and dy
        Scanner s = new Scanner(System.in);
        System.out.print("What is the dx: ");
        dx = s.nextInt();
        System.out.print("What is the dy: ");
        dy = s.nextInt();
    }
    

    /**
     * Sets new dx
     *
     * @param  newDx   the new dx
     */
    public void setDx(int newDx)
    {
        this.dx = newDx;
    }
    
     /**
     * Sets new dy
     *
     * @param  newDy   the new dy
     */
    public void setDy(int newDy)
    {
        this.dy = newDy;
    }

    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        //copy currentScan to prevScan
        boolean[][] prevScan = new boolean[currentScan.length][currentScan[0].length];
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                prevScan[row][col] = currentScan[row][col];
            }
        }
        
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        // detect the monster
        
        if(!(monsterLocationRow + this.dy <= 0 || monsterLocationRow + this.dy >= 99 || monsterLocationCol + this.dx <= 0 || monsterLocationCol + this.dx >= 99))
        {
            currentScan[monsterLocationRow + this.dy][monsterLocationCol + this.dx] = true;
            monsterLocationRow = monsterLocationRow + this.dy;
            monsterLocationCol = monsterLocationCol + this.dx;
        }
        
        // inject noise into the grid
        injectNoise();
        //compare the scans for dy's and dx's and update the accumulator
        for(int row = 0; row < prevScan.length; row++)
        {
            for(int col = 0; col < prevScan[0].length; col++)
            {
                for(int y = -5; y <= 5; y++)
                {
                    for(int x = -5; x <= 5; x++)
                    {
                        if(prevScan[row][col] == true)
                        {
                           if(!(row + y <= 0 || row + y >= 99) && !(col + x <= 0 || col + x >= 99) && currentScan[row + y][col + x] == true)
                           {
                               accumulator[y + 5][x + 5]++;
                           }                        
                        }   
                    }
                }
            }
        }
        
        // keep track of the total number of scans
        numScans++;
    }
    


    /**
     * Runs through the accumulator to get the dx that was most common
     * @return     the guess dx
     */
    public int getGuessDx()
    {
        int max = 0;
        int guessDx = 0;
        int guessDy = 0;
         for(int dx = 0; dx < accumulator.length; dx++)
        {
            for(int dy = 0; dy < accumulator[0].length; dy++)
            {
                if(accumulator[dy][dx] > max)
                {
                    max = accumulator[dy][dx];
                    guessDx = dx - 5;
                    guessDy = dy - 5;
                }
            }
        }
        return guessDx;
    }
    
    /**
     * Runs through the accumulator to get the dy that was most common
     * @return     the guess dy
     */
    public int getGuessDy()
    {
        int max = 0;
        int guessDx = 0;
        int guessDy = 0;
         for(int dx = 0; dx < accumulator.length; dx++)
        {
            for(int dy = 0; dy < accumulator[0].length; dy++)
            {
                if(accumulator[dy][dx] > max)
                {
                    max = accumulator[dy][dx];
                    guessDx = dx - 5;
                    guessDy = dy - 5;
                }
            }
        }
        return guessDy;
    }

    /**
     * inds the dx and dy of the accumulator
     * 
     * @return     String message of Guess dx and dy
     */
    public String printGuessDxDy()
    {
        int max = 0;
        int guessDx = 0;
        int guessDy = 0;
         for(int dx = 0; dx < accumulator.length; dx++)
        {
            for(int dy = 0; dy < accumulator[0].length; dy++)
            {
                if(accumulator[dy][dx] > max)
                {
                    max = accumulator[dy][dx];
                    guessDx = dx - 5;
                    guessDy = dy - 5;
                }
            }
        }
        String guessDxDy = "Guess dx = " + guessDx + "\tGuess dy = " + guessDy;
        return guessDxDy;
    }

    /**
     * returns the value of this.dx
     * @return     this.dx
     */
    public int getDx()
    {
        return this.dx;
    }
    
    /**
     * returns the value of this.dy
     * @return     this.dy
     */
    public int getDy()
    {
        return this.dy;
    }

    /**
     * Gets the actual dx and dy of the monster
     * @return     String containing dx and dy
     */
    public String printDxDy()
    {
        String dxDy = "Real dx = " + this.dx + "\tReal dy = " + this.dy;
        return dxDy;
    }


    /**
     * Sets the location of the monster
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation()
    {
        // remember the row and col of the monster's location
        Scanner s = new Scanner(System.in);
        System.out.print("What is the Monster's y position: ");
        int row = s.nextInt();
        System.out.print("What is the Monster's x position: ");
        int col = s.nextInt();
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
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
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
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
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
}
