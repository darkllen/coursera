
/**
 * Write a description of class CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFiles;
    
     public CharactersInPlay(){
    myWords = new ArrayList();
    myFiles = new ArrayList();
    }
    
    public void update(String person){
        if(!myWords.contains(person)){
            myWords.add(person);
            myFiles.add(0);
        }
        int ind = myWords.indexOf(person);
        myFiles.set(ind, myFiles.get(ind)+1);
    }
    
    public void findAllCharacters(){
    myWords.clear();
    myFiles.clear();    
    
    FileResource f = new FileResource();
    for (String l: f.lines()){
        if (l.contains(".")){
          update(l.substring(0, l.indexOf(".")));  
        }
    }
    }
    
    public void charactersWithNumParts (int num1, int num2){
    for (int i = 0; i< myWords.size(); ++i){
        if (myFiles.get(i)>=num1 && myFiles.get(i)<=num2){
            System.out.println(myFiles.get(i) + " " + myWords.get(i));
        } 
    }
    }
}
