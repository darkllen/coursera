
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {

    public String encrypt(String input, int key){
        String res = "";
        for (char c: input.toCharArray()){
         if (Character.isLetter(c))
         if (Character.isUpperCase(c))
         res+= (char)(((int)c - 65 + key)%26 + 65);
         else res+= (char)(((int)c - 97 + key)%26 + 97);
         else res+=c;
        }
        return res;
    }
    
        public String encryptTwoKeys(String input, int key1, int key2){
        String res = "";
        boolean odd = true;
        for (char c: input.toCharArray()){
         if (Character.isLetter(c)){
            if (Character.isUpperCase(c))
                if (odd)
                    res+= (char)(((int)c - 65 + key1)%26 + 65);
                else res+= (char)(((int)c - 65 + key2)%26 + 65);
            else {
                 if (odd)
                 res+= (char)(((int)c - 97 + key1)%26 + 97);
                 else res+= (char)(((int)c - 97 + key2)%26 + 97);
            }
            }
         
         else res+=c;
         
         odd=!odd;
        }
        return res;
    }
    
            public String decrypt(String input){
        String half1 = "";
        String half2 = "";
        boolean odd = true;
        for (char c: input.toCharArray()){
         if (Character.isLetter(c)){
             if (odd) half1+=c;
             else half2+=c;
            }
         
        
      
         
         odd=!odd;
        }
        
         int [] counts = new int[26];
         
         for (char d: half1.toCharArray()){
             if(Character.isUpperCase(d)) counts[(int)d - 65]++;
             else counts[(int)d - 97]++;
            }
         int maxInd = WordLengths.indexOfMax(counts);
         int key1 = (97+maxInd)-(int)'e';
         if(key1<0) key1 = (int)'e' - (97+maxInd);
         else key1 = 26-key1;
         
         counts = new int[26];
         
         for (char d: half2.toCharArray()){
             if(Character.isUpperCase(d)) counts[(int)d - 65]++;
             else counts[(int)d - 97]++;
            }
         maxInd = WordLengths.indexOfMax(counts);
         int key2 = (97+maxInd)-(int)'e';
         if(key2<0) key2 = (int)'e' - (97+maxInd);
         else key2 = 26-key2;
         
        
        
        return encryptTwoKeys(input,  key1, key2);
    }
}
