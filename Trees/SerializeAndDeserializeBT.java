package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {
    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        if(root == null) return string.toString();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        fill(q,string);

        return string.toString();
    }
    private void fill(Queue<TreeNode> q, StringBuilder string){
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                string.append("n ");
                continue;
            }
            else string.append(node.val + " ");

            if(node.left != null) q.add(node.left);
            else q.add(null);

            if(node.right != null) q.add(node.right);
            else q.add(null);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
        q.add(head);

        int i = 1;
        
        while(!q.isEmpty() && i<arr.length){
            TreeNode node = q.poll();
            if(!arr[i].equals("n")){
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            i++;
            if(!arr[i].equals("n")){
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
            i++;
        }
        return head;
    }
}
