package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class FlattenALinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = curr.next;
        ListNode newhead = head;
        ListNode prevtail = null;
        
        int size = 0;
        ListNode t = head;
        while(t!=null){
            size++;
            t = t.next;
        }

        int n = size/k;
        
        for(int i=0; i < n ; i++){
            int c=0;
            while(curr!=null && c<k){
                curr.next = prev;
                prev = curr;
                curr = nxt;
                if(nxt!=null) nxt = nxt.next;
                
                c++;
            }
            head.next = curr;
            if(prevtail!=null) prevtail.next = prev;
            
            prevtail = head;
            head = curr;
            
            if(i==0){
                newhead = prev;
            }
            
            prev = null;
        }
        return newhead;
    }
}
