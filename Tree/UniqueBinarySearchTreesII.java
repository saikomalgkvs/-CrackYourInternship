// Problem link:
// https://leetcode.com/problems/unique-binary-search-trees-ii/description/
package Tree;
import java.util.*;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        
        Map<String,List<TreeNode>> map = new HashMap<>();

        return fillTrees(1, n, map);        
    }

    private List<TreeNode> fillTrees(int start, int end, Map<String, List<TreeNode>> map) {
        String key = start + "-" + end;
        if (map.containsKey(key)) return map.get(key);
        
        List<TreeNode> trees = new ArrayList<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = fillTrees(start, i - 1, map);
            List<TreeNode> rightTrees = fillTrees(i + 1, end, map);
            
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    trees.add(root);
                }
            }
        }
        
        map.put(key, trees);
        return trees;
    }
}

