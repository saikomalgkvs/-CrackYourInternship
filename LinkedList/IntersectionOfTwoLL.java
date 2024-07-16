package LinkedList;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) return headA;
        List<ListNode> a = new ArrayList<>();
        List<ListNode> b = new ArrayList<>();

        ListNode t1 = headA;
        ListNode t2 = headB;
        
        while(t1!=null){
            a.add(t1);
            t1 = t1.next;
        }
        while(t2!=null){
            b.add(t2);
            t2 = t2.next;
        }

        int i=a.size()-1;
        int j=b.size()-1;

        while(i>=0 && j>=0){
            if(a.get(i) != b.get(j)){
                if(i==a.size()-1) return null;
                return a.get(i+1);
            }
            i--; j--;
        }
        if(i==-1) return b.get(j+1);
        if(j==-1) return a.get(i+1);
        return null;
    }
}
