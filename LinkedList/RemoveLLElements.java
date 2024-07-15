package LinkedList;
/* Remove Linked List elements */
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;

        // case if head matches with val;
        while(temp!=null && temp.val == val){
            head = head.next;
            temp.next = null;
            temp = head;
        }
        ListNode nxt = new ListNode();
        if(temp != null) nxt = temp.next;

        while(temp!=null && nxt!=null){
            if(nxt.val == val){
                temp.next = nxt.next;
                nxt = nxt.next;
            }
            else if(nxt.val != val){
                temp = nxt;
                nxt = nxt.next;
            }
        }
        return head;
    }
}