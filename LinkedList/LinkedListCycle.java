package LinkedList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;

        while(b!=null && b.next!=null){
            a = a.next;
            b = b.next.next;

            if(b==null) return false;
            if(a == b) return true;
        }
        return false;
    }
}
