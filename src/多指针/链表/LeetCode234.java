package 多指针.链表;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {

        ListNode testDummy = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        boolean flag = true;

        ListNode front = head;
        ListNode end = pre;
        pre = null;
        while(end != null){
            if(end.val != front.val) flag = false;
            front = front.next;

            ListNode temp = end.next;
            end.next = pre;
            pre = end;
            end = temp;
        }
        front.next = pre;

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

        return flag;
    }
}
