
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Main {
    
    public static void main(String[] args){
        WordPlay w = new WordPlay();
        CaesarCipher z = new CaesarCipher();
        WordLengths l = new WordLengths();
        
       FileResource r = new FileResource();
       
        //int counts[] = new int[100];
       // l.countWordLengths(r,counts);
       // System.out.println(WordLengths.indexOfMax(counts));
       
        
        
        String s = z.decrypt(r.asString());
        System.out.println(s);
    }
}
