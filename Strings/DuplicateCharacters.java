package Strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String str = "saikomalgkvs";
        printDuplicates(str);
    }

    public static void printDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int val = (int) e.getValue();
            if(val >1) System.out.println(e.getKey() + ", count = " + val);
        }
    }
}
