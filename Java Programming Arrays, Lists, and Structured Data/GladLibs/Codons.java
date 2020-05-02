
/**
 * Write a description of class Codons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Codons {
    HashMap<String, Integer> map;
    
    public Codons(){
        map = new HashMap();
    }
    public void buildCodonMap(String dna, int start){
        map.clear();
        dna = dna.trim();
        for( int i = start; i+2< dna.length(); i+=3){
            String cod = dna.substring(i, i+3);
            map.putIfAbsent(cod, 0);
            map.replace(cod, map.get(cod)+1);
        }
    }
    
    public void getMostCommonCodon(){
        int max = 0;
        String cod = "";
         for (Map.Entry me : map.entrySet()) {
          if (max < (int)me.getValue()){
              max =  (int)me.getValue();
              cod = (String) me.getKey();
            }
        }
        System.out.println(cod + " " + max);
    }
    
        public void printCodonCounts(int s, int e){

         for (Map.Entry me : map.entrySet()) {
          if ( (int)me.getValue()>=s && (int)me.getValue()<=e){
              System.out.println((String)me.getKey() + " " + me.getValue());
            }
        }
        
    }
}
