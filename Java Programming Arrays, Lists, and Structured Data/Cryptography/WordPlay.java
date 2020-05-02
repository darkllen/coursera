
/**
 * Write a description of class WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        if (ch=='a' || ch == 'e' || ch == 'i' 
        || ch == 'o' || ch == 'u' || ch=='A' || ch == 'E' || ch == 'I' 
        || ch == 'O' || ch == 'U') return true;
        return false;
    }
    
    public String replaceVowels(String s, char ch){
       return s.replaceAll("[aoieuAEIOU]", Character.toString(ch));
    }
    
        public String emphasize (String s, char ch){
       String res = "";
       char upp = Character.toUpperCase(ch);
       char low = Character.toLowerCase(ch);
       boolean odd = true;
       for (char c: s.toCharArray()){
           if (c==upp || c==low){
            if(odd) res+='*';
            else res+='+';
            }
            else res+=c;     
           odd =!odd;
        }
        return res;
    }
}
