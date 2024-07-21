package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class RearrangeLLInPlace {
    void reorderlist(Node head) {
        Deque<Node> q = new LinkedList<>();

        Node temp = head;
        while(temp!=null){
            q.addLast(temp);
            temp = temp.next;
        }
        int size = q.size();
        while(!q.isEmpty()){
            if(size == 1) q.peekFirst().next = null;
            else q.peekFirst().next = q.peekLast();

            q.removeFirst();
            size--;
            if(q.isEmpty()) break;

            if(size == 1) q.peekLast().next = null;
            else q.peekLast().next = q.peekFirst();

            q.removeLast();
            size--;
        }
    }
}
