package LinkedList;

public class SeggrateEvenOdd {
    Node divide(int N, Node head){
        
        Node even = new Node(0);
        Node odd = new Node(0);
        
        Node et = even;
        Node ot =odd;
        
        Node temp = head;
        while(temp != null){
            if(temp.data % 2 == 0){
                et.next = temp;
                et = temp;
            }
            else{
                ot.next = temp;
                ot = temp;
            }
            temp=temp.next;
        }
        
        et.next = odd.next;
        ot.next = null;
        
        return even.next;
    }
}

