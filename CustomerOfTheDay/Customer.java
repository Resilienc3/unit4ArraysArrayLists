

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    /** description of instance variable x (add comment for each instance variable) */
    private String name;
    private double sales;
    /**
     * Default constructor for objects of class Customer
     */
    public Customer(String name, double amount)
    {
        this.name = name;
        this.sales = amount;
    }
    
    public double getSales()
    {
        return sales;
    }

    public String getName()
    {
        return name;
    }
    
}
