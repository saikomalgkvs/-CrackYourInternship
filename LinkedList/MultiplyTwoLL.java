package LinkedList;
/* Multiply two linked lists */
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        
        long a = first.data;
        long b = second.data;
        
        Node t1 = first.next;
        while(t1 != null){
            a = a*10 + t1.data;
            t1 = t1.next;
        }
        
        Node t2 = second.next;
        while(t2 != null){
            b = b*10 + t2.data;
            t2 = t2.next;
        }
        return a*b;
    }
}
