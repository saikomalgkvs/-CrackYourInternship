package LinkedList;

public class PartionList {
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(500);
        ListNode b = new ListNode(500);
        
        ListNode temp = head;
        ListNode tempa = a;
        ListNode tempb = b;

        while(temp != null){
            if(temp.val < x){
                tempa.next = new ListNode(temp.val);
                tempa = tempa.next;
            }
            else{
                tempb.next = new ListNode(temp.val);
                tempb = tempb.next;

            }
            temp = temp.next;
        }
        tempa.next = b.next;
        return a.next;
    }
}
