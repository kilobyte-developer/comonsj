import java.util.*;
import java.io.*;

public class LinkedListDemo 
{
    public static void main(String args[]) throws Exception
    {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList li = new LinkedList();

        System.out.println("\nEnter number of your friends:");
        n = Integer.parseInt(br.readLine());

        System.out.println("\nEnter your friends' names:");
        for (int i = 1; i <= n; i++) 
        {
            li.add(br.readLine());
        }

        System.out.println("\nLinked List content is: " + li);
    }
}
