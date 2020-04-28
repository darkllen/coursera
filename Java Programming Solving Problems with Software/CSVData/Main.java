
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
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            double count = 0;
            double w = 0;
            String t = "";
            for (CSVRecord rec : parser){
            String v = rec.get("TemperatureF");
            String h = rec.get("Humidity");
            if (Double.parseDouble(h) >= 80){
            count += Double.parseDouble(v);
            w++;
           // t = rec.get("DateUTC");
            }   
            }

        System.out.println(count/w);
      //  System.out.println(t);
        
    }
}


            // if(exports.indexOf("cotton")!=-1 && exports.indexOf("flowers")!=-1){
                // count++;
                // if (count==2){
                // System.out.println(rec.get("Country"));
                // }
            // }