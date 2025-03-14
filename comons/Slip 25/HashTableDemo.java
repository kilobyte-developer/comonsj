import java.util.*;
import java.io.*;

class HashTableDemo 
{
    public static void main(String args[]) 
    {
        Hashtable ht = new Hashtable();
        Enumeration names;
        String str;

        ht.put("Amar", (2222222222L));
        ht.put("Anil", (3333333333L));
        ht.put("Soham", (8888888888L));
        ht.put("Kiran", (9999999999L));
        ht.put("Williams", (4444444444L));

        names = ht.keys();
        while (names.hasMoreElements()) 
        {
            str = (String) names.nextElement();
            System.out.println(str + ": " + ht.get(str));
        }
    }
} 