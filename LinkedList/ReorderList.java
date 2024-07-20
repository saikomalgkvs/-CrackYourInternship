package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        Deque<ListNode> q = new LinkedList<>();

        ListNode temp = head;
        while(temp!=null){
            q.addLast(temp);
            temp = temp.next;
        }
        int size = q.size();
        System.out.println(q.size());
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
