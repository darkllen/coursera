import java.util.*;
import java.io.*;
import edu.duke.*;

public class VigenereBreaker {
    public char mostCommonCharIn(HashSet<String> dict){
        int[] key = new int[26];
        for (String s: dict){
            s = s.toLowerCase();
            for (int i = 0 ; i< s.length(); ++i){
                if(s.charAt(i) >= 97 && s.charAt(i) <=122){
                                int y = s.charAt(i)-97;
                                try{
                                    key[y]++;
                                }
                                catch(ArrayIndexOutOfBoundsException ex){
                                    System.out.println(s.charAt(i));
                                    System.out.println((int)s.charAt(i));
                                }
                                
                }

            }
        }
        int max = 0;
        char res = ' ';
        for(int i = 0; i< key.length; ++i){
            if (max < key[i]){
                max = key[i];
                res = (char)(i+97);
            }
        }
        return res;
    }
    
    public String breakForAllLangs(String encr, HashMap<String, HashSet<String>> map){
        int max = 0;
        String res = "";
        String lang = "";
        
        for (Map.Entry<String, HashSet<String>> m: map.entrySet()){
            String s = breakForLanguage(encr,  m.getValue());
            if (max < countWords(s, m.getValue())){
            max = countWords(s, m.getValue()); 
            res = s;
            lang = m.getKey();
            }
        }
        System.out.println(lang);
        return res;
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> set = new HashSet();
        for (String l: fr.lines()){
        l = l.toLowerCase();
        set.add(l);
        }
        return set;
    }
    
    public int countWords(String m, HashSet<String> dict){
        int count  = 0;
        for(String s: m.split("\\W+")){
            if (dict.contains(s.toLowerCase()))count++;
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted,  HashSet<String> dict){
        int max = 0;
        String r = "";
        for(int i = 1; i<=100; ++i){
            int[] keys = tryKeyLength(encrypted, i, mostCommonCharIn(dict));
            VigenereCipher v = new VigenereCipher(keys);
            String res = v.decrypt(encrypted);
            if (max < countWords(res, dict)) {
                max = countWords(res, dict);
                r = res;
            }
        } 
        return r;
    }
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String res = "";
        for (int i = whichSlice; i<=message.length()-1; i+=totalSlices)
        res+=message.charAt(i); 
        return res;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker k = new CaesarCracker(mostCommon);
        for (int i = 0; i<klength; ++i) key[i] = k.getKey(sliceString(encrypted, i, klength));
        return key;
    }

    public void breakVigenere () {
       FileResource f = new FileResource();
       DirectoryResource dicts = new DirectoryResource();
       HashMap<String, HashSet<String>> set = new HashMap();
       
       for (File file : dicts.selectedFiles()){
           set.put(file.getName(), readDictionary(new FileResource(file)));
        }

       String res = breakForAllLangs(f.asString(), set);
       System.out.println(res);
    }
    
    public static void main(String[] args){
        VigenereBreaker v = new VigenereBreaker();
        v.breakVigenere();
    }
    
}
