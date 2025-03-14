import java.util.*;

class HashMapDemo 
{
    public static void main(String args[]) 
    {
        HashMap ha = new HashMap(); // Raw type (not recommended)
        ha.put(10, "Java");
        ha.put(20, "Operating System");
        ha.put(30, "SoftwareTesting Tools");
        ha.put(40, "Compiler Constructor");
        ha.put(50, "Web Technologies");

        // Before Sorting
        System.out.println("Before Sorting:");
        Set set = ha.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) 
        {
            Map.Entry me = (Map.Entry) it.next(); // Typecasting needed
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        // After Sorting (Using TreeMap)
        Map map = new TreeMap(ha);  // Sorting by keys with TreeMap
        System.out.println("After Sorting:");
        Set set1 = map.entrySet();
        Iterator it2 = set1.iterator();
        while (it2.hasNext()) {
            Map.Entry me2 = (Map.Entry) it2.next(); // Typecasting needed
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
        }
    }
}
