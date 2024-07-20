package LinkedList;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode t1 = null;
        ListNode t2 = head;
        ListNode t3 = head.next;

        if(t3 == null) return head; // case if list is single node.

        for(int i=0; i<left-1; i++){
            t1 = t2;
            t2 = t3;
            t3 = t3.next;
        }
        ListNode first = t1;
        ListNode second = t2;
        

        for(int i=left; i<=right; i++){
            t2.next = t1;
            t1 = t2;
            t2 = t3;
            if(t3 != null) t3 = t3.next;
        }

        if(left == 1 && t2 == null) return t1; // if have to reverse full list.

        second.next = t2;
        if(first == null) return t1;
        else first.next = t1;

        return head;
    }
}
