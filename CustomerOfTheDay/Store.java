import java.util.ArrayList;


/**
 * Write a description of class Store here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Store
{
    private ArrayList<Customer> tops;
    
    public void addSale(String customerName, double amount)
    {
        this.tops.add(new Customer(customerName, amount));
    }
    
    public String nameOfBestCustomer()
    {
        double topSale = 0.0;
        String topName;
        for (int i = 0; i < this.tops.size(); i++)
        {
            if (this.tops[i].getSales > topSale)
            {
                this.topSale = tops[i].getSales;
                this.topName = tops[i].getName;
            }
        }
        return topName;
    }
    
    public static void main(String [] args)
    {
        Store s = new Store();
        String sent = "y";
        while (sent.equals("y"))
        {
            s.addSale();
        }
        s.nameOfBestCustomer();
    }
    
}
