import java.util.*;
import java.io.*;

class SETB1 
{
    public static void main(String[] args) throws Exception 
    {
        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet ts = new TreeSet();

        System.out.println("Enter the number of elements:");
        int no = Integer.parseInt(br.readLine());
        System.out.println("Enter the element: ");

        for (int i = 0; i < no; i++) 
        {
            element = Integer.parseInt(br.readLine());
            ts.add(element);
        }

        System.out.println("The elements in sorted order: " + ts);

        System.out.println("Enter element to be searched: ");
        element = Integer.parseInt(br.readLine());

        if (ts.contains(element))
            System.out.println("Element is found");
        else
            System.out.println("Element is NOT found");
    }
}