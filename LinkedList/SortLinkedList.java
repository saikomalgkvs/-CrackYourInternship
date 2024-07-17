/* Sort a linked list of 0s, 1s and 2s */

package LinkedList;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

public class SortLinkedList {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        int count = 0;
        
        Node temp = head;
        Node set = head;
        while(count<3 && set!=null){
            if(temp.data == count){
                temp.data = set.data;
                set.data = count;
                set = set.next;
            }
            temp = temp.next;
            if(temp == null){
                count++;
                temp = head;
            }
        }
        return head;
    }
}
