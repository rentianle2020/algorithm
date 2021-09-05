package leetcode;

/**
 * 剑指offer 22
 */
public class GetKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        ListNode ahead = head;
        ListNode behind = head;

        for (int i = 0; i < k - 1; i++) {
            if(ahead.next == null) return null;
            ahead = ahead.next;
        }

        while(ahead.next != null){
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }
}
