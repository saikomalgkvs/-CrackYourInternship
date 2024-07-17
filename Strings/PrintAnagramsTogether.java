package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagramsTogether {
    public List<List<String>> Anagrams(String[] string_list) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        for(String str : string_list){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        Collection<List<String>> list = map.values();
        List<List<String>> result = new ArrayList<>();
        
        for(List<String> group : list){
            result.add(group);
        }
        return result;
    }
}
