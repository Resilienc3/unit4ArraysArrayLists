

import java.util.Scanner;
public class ArrayOps2
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] values;
    private int currentSize;
    
    public ArrayOps2(int[]  initialValues)
    {
        values = initialValues;
        currentSize = values.length;
    }
    
    public void shiftRight()
    {
        int last = values[currentSize -1];
        int temp = values[1];
        values[1] = values[0];
        for( int i = 1; i < currentSize - 1; i++)
        {
            values[i] = temp;
            temp = values[i+1];
            
        }
        values[0] = last;
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
        int preV = values[0];
        
        for(int i = 1; i < currentSize - 1; i ++)
        {
            int temp = values[i];
            if(values[i-1]> values[i])
            {
                values[i] = preV;
            }
            else if(values[i+1]> values[i])
            {
                values[i] = values[i+1];
            }
            preV = temp;
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
        else
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
