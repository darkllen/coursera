import edu.duke.*;
import java.util.*;

public class GladLib {
    HashMap<String, ArrayList<String>> map;
    
    ArrayList<String> used;
    HashSet<String> cat;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
        private void initializeFromSource(String source) {
        map = new HashMap();
        used = new ArrayList();
        cat = new HashSet();
        map.put("adjective", readIt(source+"/adjective.txt"));
        map.put("noun", readIt(source+"/noun.txt"));
        map.put("color", readIt(source+"/color.txt"));
        map.put("country", readIt(source+"/country.txt"));
        map.put("name", readIt(source+"/name.txt"));
        map.put("animal", readIt(source+"/animal.txt"));
        map.put("timeframe", readIt(source+"/timeframe.txt"));
        map.put("verb", readIt(source+"/verb.txt"));
        map.put("fruit", readIt(source+"/fruit.txt"));
             
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        
        if (label.equals("country")) {
            return randomFrom(map.get("country"));
        }
        if (label.equals("color")){
            return randomFrom(map.get("color"));
        }
        if (label.equals("noun")){
            return randomFrom(map.get("noun"));
        }
        if (label.equals("name")){
            return randomFrom(map.get("name"));
        }
        if (label.equals("adjective")){
            return randomFrom(map.get("adjective"));
        }
        if (label.equals("animal")){
            return randomFrom(map.get("animal"));
        }
        if (label.equals("timeframe")){
            return randomFrom(map.get("timeframe"));
        }
        if (label.equals("verb")){
            return randomFrom(map.get("verb"));
        }
        if (label.equals("fruit")){
            return randomFrom(map.get("fruit"));
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        
        String sub = getSubstitute(w.substring(first+1,last));
        cat.add(w.substring(first+1,last));
        while (used.contains(sub)) sub = getSubstitute(w.substring(first+1,last));
        used.add(sub);
        
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
    }
    
    public void totalWordsInMap (){
    int num = 0;
    for (Map.Entry me: map.entrySet()){
        num+=((ArrayList)me.getValue()).size();
    }
    System.out.println(num);
    }
    
    public void totalWordsConsidered (){
        int num = 0;
        for (String s: cat){
            System.out.println(s);
            if(!s.equals("number"))
            num+=map.get(s).size();
        }
        System.out.println(num);
    }


}
