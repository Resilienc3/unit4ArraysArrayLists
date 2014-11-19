

import java.util.Scanner;
public class ArrayOps2
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] values;
    private int currentSize;
    
    public ArrayOps2()
    {
        values = new int[10];
        currentSize = 0;
    }

    public void fillWithSquares()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("How big would you like the array to be? (10 or less): ");
        for( int i = 0; i <= 5; i++)
        {
            values[i] = i*i;
            currentSize++;
        }
    }
    
    public void shiftRight()
    {
        for( int i = 0; i < currentSize - 1; i++)
        {
            int temp = values[i+1];
            for(int x = 0; x <1; x++)
            {
                values[i] = values[i+1];
                   
            }   
            
        }
        values[0] = values[currentSize-1];
    }
    
    public void swapFirstLast( int index1, int index2)
    {
        int temp = values[0];
        values[0] = values[1];
        values[1] = temp;
    }
    
    public void replaceEvens()
    {
        for(int i = 0; i < currentSize; i ++)
        {
            if(values[i]%2 == 0)
            {
                values[i] = 0;
            }
        }
    }
    
    public void bigger()
    {
        for(int i = 1; i < currentSize - 1; i ++)
        {
            if(values[i-1]> values[i])
            {
                values[i] = values[i-1];
            }
            else if(values[i+1]> values[i])
            {
                values[i] = values[i+1];
            }
        }
    }
    
    public void removeMid()
    {
        int index =  values.length/2;
        if( currentSize % 2 == 0)
        {
            values[index] = values[currentSize - 1];
            currentSize--;
            values[index+1] = values[currentSize -1];
            currentSize--;
        }
        else if( currentSize % 2 == 1)
        {
            values[index] = values[currentSize - 1];
            currentSize--;
        }
    }
    
    public void EvenToFront()
    {
        for( int i = (values.length - 1); i >= 0; i--)
        {
        }
        
    }
    
    
}
