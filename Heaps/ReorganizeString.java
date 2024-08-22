package Heaps;

import java.util.PriorityQueue;

class Pair{
    char key;
    int val;
    Pair(char key, int val){
        this.key = key;
        this.val = val;
    }
    @Override
    public String toString(){
        return "[" + key +","+ val + "]";
    }
}
public class ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();
        
        int[] arr = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);

        for(int i=0; i<n; i++){
            arr[s.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(arr));

        int sum = 0;
        for(int i=0; i<26; i++){
            if(arr[i] != 0){
                pq.add(new Pair((char)(i+97), arr[i]));
                sum += arr[i];
            }
        }
        // System.out.println(pq);
        
        int max = pq.peek().val;
        sum = sum-max;

        if(sum < max-1) return "";
        

        char[] charay = new char[n];
        int ci = 0;

        Pair prevPair = null;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            charay[ci] = pair.key;
            pair.val--;

            if(prevPair != null && prevPair.val > 0) pq.add(prevPair);
            prevPair = pair;
            ci++;
        }
                
        return new String(charay);

    }
}