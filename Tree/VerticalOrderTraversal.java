package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(map);
        for(int i : map.keySet()){
            List<Integer> pair = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> treemap = map.get(i);
            for(int l : treemap.keySet()){
                PriorityQueue<Integer> queue = treemap.get(l);
                while(!queue.isEmpty()){
                    pair.add(queue.poll());
                }
            }
            result.add(pair);
        }
        return result;
    }
    private void dfs(TreeNode node, Map<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map, int i, int l){
        if(node == null) return;
        
        map.putIfAbsent(i, new TreeMap<>());
        map.get(i).putIfAbsent(l, new PriorityQueue<>());
        map.get(i).get(l).add(node.val);

        dfs(node.left, map, i-1, l+1);
        dfs(node.right, map, i+1, l+1);
    }
}
