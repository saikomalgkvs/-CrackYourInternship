package Trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    Map<Long,Integer> map;
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        count = 0;
        dfs(root, 0, targetSum);
        return count;
    }
    public void dfs(TreeNode node, long presum, int target){
        if(node == null) return;

        presum += node.val;

        if(presum == target) count++;

        if(map.containsKey(presum - target)) count += map.get(presum - target);

        map.put(presum, map.getOrDefault(presum, 0) + 1);

        dfs(node.left, presum, target);
        dfs(node.right, presum, target);

        map.put(presum, map.get(presum)-1);
    }
}
