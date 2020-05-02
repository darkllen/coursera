
/**
 * Write a description of class WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFiles;
    
    public WordFrequencies(){
    myWords = new ArrayList();
    myFiles = new ArrayList();
    }
    
    public void findUnique(){
    myWords.clear();
    myFiles.clear();
    
    FileResource f = new FileResource();
    for (String w: f.words()){
        w = w.toLowerCase();
        if (!myWords.contains(w)) {
            myWords.add(w);
            myFiles.add(0);
        }
        int ind = myWords.indexOf(w);
        myFiles.set(ind, myFiles.get(ind)+1);
    }
    
    }
    
    public void findIndexOfMax (){
        int max = 0;
        int ind = 0;
        for (int i = 0; i< myFiles.size(); ++i){
            if (max< myFiles.get(i)) {
                max = myFiles.get(i);
                ind = i;
            }
        }
        System.out.println(myFiles.get(ind) + " " + myWords.get(ind));
    }
    
}
