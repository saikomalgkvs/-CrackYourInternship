package LinkedList;

public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode temp = head;
        while(temp!=null){
            sb.append(temp.val);
            temp = temp.next;
        }
        String a = sb.toString();
        String b = sb.reverse().toString();

        return a.equals(b);
    }
}
