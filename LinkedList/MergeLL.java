package LinkedList;

/* Merge two sorted linked lists */

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
class MergeLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode newHead = null;
        ListNode t1 = list1;
        ListNode t2 = list2;

        if(t1.val <= t2.val) {
            newHead = t1;
            t1 = t1.next;
        } else {
            newHead = t2;
            t2 = t2.next;
        }
        ListNode curr = newHead;
        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                curr.next = t1;
                curr = curr.next;
                t1 = t1.next;
            }
            else{
                curr.next = t2;
                curr = curr.next;
                t2 = t2.next;
            }
        }

        while(t1!=null){
            curr.next = t1;
            curr = curr.next;
            t1 = t1.next;
        }
        while(t2!=null){
            curr.next = t2;
            curr = curr.next;
            t2 = t2.next;
        }
        return newHead;
    }
}
