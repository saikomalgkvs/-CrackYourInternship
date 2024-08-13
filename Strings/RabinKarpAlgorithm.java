// Rabin-Karp Algorithm for Pattern Searching
// https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

package Strings;

import java.util.ArrayList;

public class RabinKarpAlgorithm{
    public ArrayList<Integer> search(String pattern, String text){
        
        ArrayList<Integer> ans = new ArrayList<>();
     
        int m = text.length();
        int n = pattern.length();
        int modii = 101;
        int patternhash = calculatehash(pattern,n,modii);
        int texthash = calculatehash(text,n,modii);
        
        for(int i =0; i<=m-n;i++){
            if(patternhash == texthash && checkforcharbychar(text,i,pattern)) ans.add(i+1);

            if(i<m-n) texthash= recalculatehash(text,i,n,texthash,modii);
        }
        return ans;
    }
    public static boolean checkforcharbychar(String texti ,int p , String patterni){
        int patilengthj = patterni.length();
        
        for(int i =0;i<patilengthj;i++){
            if(texti.charAt(p+i)!=patterni.charAt(i)) return false;
        }
        return true;
    }
    
    public static  int calculatehash(String texti, int  ni,int dii){
        int hash = 0;
        
        for(int i=0;i<ni;i++){    
            hash = (hash * dii + texti.charAt(i)) % dii;
        }
        return hash;
    }
    
    public static int recalculatehash(String str, int oldindex, int patternlength, int oldhash, int prime) {
        int newhash = oldhash - (str.charAt(oldindex) * powModInverse(prime, patternlength - 1, prime)) % prime;
        newhash = (newhash * prime + str.charAt(oldindex + patternlength)) % prime;
        return newhash >= 0 ? newhash : newhash + prime;
    }
    
    public static int powModInverse(int base, int exponent, int mod) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exponent /= 2;
        }
        return result;
    }
    
}