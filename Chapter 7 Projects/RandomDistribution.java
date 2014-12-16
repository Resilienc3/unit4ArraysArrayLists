import java.util.Scanner;




public class RandomDistribution
{
  
    public void randomTest()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many random numbers do you want to generate?");
        int randAmount = in.nextInt();
        System.out.println("What is the number of values for each random draw?");
        int numValues = in.nextInt();
        
        int[] x = new int[numValues];
    
        for (int i = 0; i <= randAmount; i++) 
        {
            int y = (int)Math.random() * numValues;
            x[y]+= 1;
            
        }
        
        for (int z : x)
        {
            System.out.println(z);
        }
    }

}
