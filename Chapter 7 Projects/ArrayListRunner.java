import java.util.ArrayList;

public class ArrayListRunner
{
   public static void main(String[] args)
   {
       ArrayList<String> names = new ArrayList<String>();
       System.out.println(names);
        
       //a)
       String[] newNames= {"Alice", "Bob", "Connie", "David", "Edward", "Fran", "Gomez", "Harry"};
       for(int x = 0; x < newNames.length; x++)
       {
           names.add(newNames[x]);
       }
       System.out.println(names);
       
       //b)
       String first = names.get(0);
       String last = names.get(names.size()-1);
       System.out.println("First name: " + first + "\tLast name: " + last);
       
       //c)
       System.out.println(names.size());
       
       //d)
       System.out.println(names.get(names.size()-1));
       
       //e)
       names.set(0, "Alice B. Toklas");
       System.out.println(names);
       
       //f)
       names.add(4, "Doug");
       System.out.println(names);
       
       //g)
       for (String i : names)
       {
           System.out.println(i);
       }
      

       //h)
       ArrayList<String> names2 = new ArrayList<String>(names);
       System.out.println(names2);
       
       //i)
       names.remove(0);
       System.out.println(names);
       System.out.println(names2);
       
   }
} 