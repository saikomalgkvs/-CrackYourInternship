package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        Queue<ListNode> q = new LinkedList<>();

        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            if(q.size() <= n) q.add(temp);
            else{
                q.poll();
                q.add(temp);
            }
            temp = temp.next;
            size++;
        }
        if(n == size) return head.next; 
        
        ListNode a = q.poll();
        q.poll();

        if(!q.isEmpty()) a.next = q.poll();
        else a.next = null;

        return head;
    }
}
