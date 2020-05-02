
/**
 * Write a description of class WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    public void countWordLengths(FileResource f, int[] counts){
        for (String s: f.words()){
            int l = s.length();
            if(!Character.isLetter(s.charAt(0)))
            l--;
            if(!Character.isLetter(s.charAt(s.length()-1)))
            l--;
            if (l!=-1)
            counts[l]++;
        }
    }
    
    
    
        public static int indexOfMax(int[] counts){
            int max = 0;
            int ind = 0;
        for (int i=0; i< counts.length; ++i){
            if (counts[i]>max) {max = counts[i]; ind = i;} 
        }
        return ind;
    }
}
