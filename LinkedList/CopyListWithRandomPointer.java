package LinkedList;

import java.util.ArrayList;
import java.util.List;


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node newHead = new Node(head.val);
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        

        Node temp = head;
        Node newtemp = newHead;
        while(temp.next!=null){
            list1.add(temp);
            list2.add(newtemp);

            newtemp.next = new Node(temp.next.val);
            temp = temp.next;
            newtemp = newtemp.next;
        }

        list1.add(temp);
        list2.add(newtemp);

        temp = head;
        newtemp = newHead;
        while(temp!=null){
            if(temp.random == null) newtemp.random = null; 
            else newtemp.random = list2.get(list1.indexOf(temp.random));
            temp = temp.next;
            newtemp = newtemp.next;
            
        }
        return newHead;
    }
}
