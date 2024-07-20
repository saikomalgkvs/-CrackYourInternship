package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result;

    Combinations(){
        result = new ArrayList<>();
    }

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
            dfs(list, i+1, n, k);
            list.remove(list.size() -1);
        }
        return result;
    }
    public void dfs(List<Integer> list, int i, int n, int k){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int idx = i; idx<=n; idx++){
            list.add(idx);
            dfs(list, idx+1, n, k);
            list.remove(list.size() -1);
        }
    }
}
