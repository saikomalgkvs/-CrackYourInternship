package LinkedList;
/* Delete nodes having greater value */
public class DeleteNodes {
    Node compute(Node head)
    {
        if(head.next == null) return head;;
        head.next = compute(head.next);
        
        if(head.data < head.next.data) return head.next;
        else return head;
    }    
}
