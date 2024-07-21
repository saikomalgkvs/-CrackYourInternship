package LinkedList;

import java.math.BigInteger;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        ListNode t1 = l1;
        while(t1 != null){
            n1.append(t1.val);
            t1 = t1.next;
        }

        ListNode t2 = l2;
        while(t2 != null){
            n2.append(t2.val);
            t2 = t2.next;
        }
        BigInteger b1 = new BigInteger(n1.toString());
        BigInteger b2 = new BigInteger(n2.toString());
        
        if(b1.intValue() == 0) return l2;
        if(b2.intValue() == 0) return l1;

        b1 = b1.add(b2);
        String number = b1.toString();

        ListNode node = new ListNode(100);
        t1 = node;
        for(char c : number.toCharArray()){
            t1.next = new ListNode(c - '0');
            t1 = t1.next;
        }
        return node.next;
    }
}
