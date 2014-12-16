


public class ArrayOps
{
    private int currentSize;
    double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
    
    public void numItems()
    {
        System.out.println("Length of Array: "+x.length);
        System.out.println("First Item: "+ x[0]);
        System.out.println("Last Item: " + x[x.length - 1]);
        
        for( int i = 0; i < x.length; i++)
        {
            System.out.println(x[i]);
        }
        
        for( int i = 0; i < x.length; i++)
        {
            System.out.println("Item #" +(i+1)+": " + x[i]);
        }
        
        for( int i = (x.length - 1); i >= 0; i--)
        {
            System.out.println("Item #" +(i+1)+": "+ x[i]);
        }
        
        for(double z : x)
        {
            System.out.println(z);
        }
        
    }

}
