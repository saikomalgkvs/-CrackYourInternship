package Arrays;

import java.util.*;

class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer, LinkedHashSet<Integer>> map; // set stores the indies of it key in the list
    Random rand = new Random();

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean hasElement = map.containsKey(val);
        
        if(!hasElement) map.put(val, new LinkedHashSet<>());
        map.get(val).add(list.size());

        list.add(val);

        return !hasElement;
    }
    
    public boolean remove(int val) {
        boolean hasElement = map.containsKey(val);
        if(!hasElement) return false;

        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);

        int listSize = list.size();
        if(idx < listSize-1){
            int last = list.get(listSize-1);
            list.set(idx, last);
            map.get(last).remove(listSize-1);
            map.get(last).add(idx);
        }
        list.remove(listSize-1);

        if(map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */