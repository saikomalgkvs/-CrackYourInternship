package LinkedList;

import java.math.BigInteger;

public class SubtractionInLinkedList {
    public Node subLinkedList(Node head1, Node head2) {
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        // remove trailing zeros;
        while(head1!=null && head1.data == 0){
            head1 = head1.next;
        }
        while(head2!=null && head2.data == 0){
            head2 = head2.next;
        }
        
        if(head1 == null) head1 = new Node(0);
        if(head2 == null) head2 = new Node(0);
        if(head1.data == 0) return head2;
        if(head2.data == 0) return head1;
        
        Node t1 = head1;
        boolean flag = true;
        while(t1 != null){
            n1.append(t1.data);
            t1 = t1.next;
        }

        Node t2 = head2;
        while(t2 != null){
            n2.append(t2.data);
            t2 = t2.next;
        }
        
        BigInteger b1 = new BigInteger(n1.toString());
        BigInteger b2 = new BigInteger(n2.toString());
        
        if(b1.intValue() == 0) return head2;
        if(b2.intValue() == 0) return head1;

        BigInteger max = b1.max(b2);
        BigInteger min = b1.min(b2);
        
        String number = max.subtract(min).toString();

        Node node = new Node(100);
        t1 = node;
        for(char c : number.toCharArray()){
            t1.next = new Node(c - '0');
            t1 = t1.next;
        }
        return node.next;
    }
}
