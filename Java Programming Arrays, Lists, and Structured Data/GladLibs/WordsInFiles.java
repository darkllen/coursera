
/**
 * Write a description of class WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;
public class WordsInFiles {
    HashMap<String, ArrayList<String>> map;
    
    WordsInFiles(){
        map = new HashMap();
    }
    
    public void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for (String w: fr.words()){
            map.putIfAbsent(w, new ArrayList());
            if (!map.get(w).contains(f.getName()))map.get(w).add(f.getName());
        }
    }
    
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dir = new DirectoryResource();
        for (File f: dir.selectedFiles()){
            addWordsFromFile(f);
        }
        
    }
    
    public int maxNumber(){
        int max = 0;
        for (Map.Entry me : map.entrySet()){
            if (max < ((ArrayList)me.getValue()).size()) max =((ArrayList)me.getValue()).size(); 
        }
        return max;
    }
    
    public ArrayList<String> wordsInNumFiles (int num){
        ArrayList<String> arr = new ArrayList();
        for (Map.Entry me : map.entrySet()){
            if (num == ((ArrayList)me.getValue()).size()) arr.add((String)me.getKey()); 
        }
        return arr;
        
    }
    
    public void printFilesIn(String word){
        System.out.println(map.get(word));
        
    }
    
    
}
