package LinkedList;

public class RemoveDupFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;

        ListNode temp1 = temp;
        ListNode temp2 = head;

        while (temp2 != null){
            while (temp2.next != null && temp2.next.val == temp2.val){
                temp2 = temp2.next;
            }

            if(temp1.next == temp2) temp1 = temp2;
            else temp1.next = temp2.next;
            temp2 = temp2.next;
        }
        return temp.next;
    }
}
