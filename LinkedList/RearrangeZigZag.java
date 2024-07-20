package LinkedList;

// Rearrange a Linked List in Zig-Zag fashion

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
public class RearrangeZigZag {
    Node zigZag(Node head) {
        boolean greater = true;
        
        Node temp = head;
        
        while(temp!=null && temp.next!=null){
            if(greater){
                if(temp.data > temp.next.data){
                    int val = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = val;
                }
                greater = false;
            }
            else{
                if(temp.data < temp.next.data){
                    int val = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = val;
                }
                greater = true;
                
            }
            temp = temp.next;
        }
        return head;
    }
}
