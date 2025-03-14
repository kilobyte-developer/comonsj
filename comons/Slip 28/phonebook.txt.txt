import java.util.*;
import java.io.*;

public class Phonebook {
    public static void main(String args[]) {
        try {
            // Corrected FileInputStream path
            FileInputStream fis = new FileInputStream("myfile.txt");
            Scanner sc = new Scanner(fis); // Default scanner behavior
            
            Hashtable<String, String> ht = new Hashtable<String, String>();
            String[] strarray;
            String a, str;
            
            // Reading the file line by line
            while (sc.hasNextLine()) {
                a = sc.nextLine();
                strarray = a.split("\t");  // Split explicitly by tab character
                
                // Ensure the line contains both name and phone number
                if (strarray.length < 2) {
                    System.out.println("Skipping invalid line: " + a);
                    continue;  // Skip invalid lines
                }
                
                // Trim spaces before adding to hashtable
                ht.put(strarray[0].trim(), strarray[1].trim());
                System.out.println("Hashtable values are: " + strarray[0].trim() + ": " + strarray[1].trim());
            }
            
            // Reading user input
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the name as given in the phone book:");
            str = s.nextLine().trim();  // Use nextLine to capture full input
            
            // Check if name exists in hashtable
            if (ht.containsKey(str)) {
                System.out.println("Phone no is: " + ht.get(str));  // Corrected method call
            } else {
                System.out.println("Name is not matching with the phone book");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);  // Handle other exceptions
        }
    }
}
