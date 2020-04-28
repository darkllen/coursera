
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.File;
import edu.duke.*;
import org.apache.commons.csv.*;
public class Main {
 public static void main(String[] args){
            DirectoryResource dir = new DirectoryResource();
            int y = 0;
            
          
            
            
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser(false);
            int count = 0;
            int countg = 0;
            for (CSVRecord rec : parser){
            
            String name = rec.get(0);
            String gender = rec.get(1);
            if (gender.equals("M"))count++;
            
            int num = Integer.parseInt(rec.get(2));
            
            if (count ==430) System.out.println(name);
           // if (name.equals("Owen") && gender.equals("M")) {
 
//System.out.println(count);
          
        //    }

            }
     
            

            
        
    }
}
