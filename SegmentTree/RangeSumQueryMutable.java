class NumArray {
    private class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;
        Node(int b, int c){
            start = b;
            end = c;
        }
    }
    private Node head;
    private int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
        head = build(head, 0, nums.length-1);
        // inorder(head);
        // System.out.println();
    }
    private Node build(Node node, int start, int end){
        if(node == null){
            node = new Node(start, end);
            if(start == end){
                node.data = arr[start];
                return node;
            }
        }
        int mid = start + (end - start)/2;
        node.left = build(node.left, start, mid);
        node.right = build(node.right, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void update(int index, int val) {
        arr[index] = val;
        head.data = update(head, index, val);
        // inorder(head);
        // System.out.println();
    }
    private int update(Node node, int i, int data){
        if(node.start == i && node.end == i){
            return data;
        }
        else if(node.start <= i && i <= node.end){
            node.left.data = update(node.left, i, data);
            node.right.data = update(node.right, i , data);
            node.data = node.left.data + node.right.data;
        }
        return node.data;
    }
    
    public int sumRange(int left, int right) {
        return sum(head, left, right);
    }
    private int sum(Node node, int left, int right){
        if(node.start >= left && node.end <= right) return node.data;
        else if(node.end < left || node.start > right) return 0;
        else{
            return sum(node.left, left, right) + sum(node.right, left, right);
        }

    }
    // public void inorder(Node node){
    //     if(node == null) return;
    //     inorder(node.left);
    //     System.out.print(node.data + " ");
    //     inorder(node.right);
    // }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */