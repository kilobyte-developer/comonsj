import java.util.*;
import java.io.*;

public class ArrayListDemo 
{
    public static void main(String args[]) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList al = new ArrayList();

        System.out.println("\nHow many City?");
        int n = Integer.parseInt(br.readLine());
        System.out.println("\n Enter City names:");

        for (int i =0  ; i <= n; i++) 
        {
            al.add(br.readLine());
        }
        System.out.println("Entered cities are :" + al);
        al.removeAll(al);
        System.out.println("All cities are removed from the ArrayList:" + al);
    }
}