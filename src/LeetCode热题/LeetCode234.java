package LeetCode热题;

import java.util.*;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {

        if(head.next == null) return true;

        ListNode dummy = null;
        ListNode cur = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            cur.next = dummy;
            dummy = cur;
            cur = slow;
        }

        if(fast != null){
            cur = cur.next;
        }

        while(cur != null){
            if(cur.val != dummy.val) return false;
            cur = cur.next;
            dummy = dummy.next;
        }

        return true;
    }
}
