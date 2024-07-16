package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        while(t1!=null && t2!=null){
            int sum = t1.val + t2.val;
            t1.val = sum;
            t2 = t2.next;

            // condition if l1 length is less than l2
            if(t1.next == null){
                t1.next = t2;
                break;
            }
            t1 = t1.next;
        }
        
        t1 = l1;
        while(t1!=null){
            if(t1.val>=10){
                t1.val = t1.val%10;
                if(t1.next != null) t1.next.val += 1;
                else t1.next = new ListNode(1);
            }
            t1 = t1.next;
        }
        return l1;
    }
}
