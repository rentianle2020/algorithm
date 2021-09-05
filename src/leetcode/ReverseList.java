package leetcode;

/**
 * 剑指offer 24
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        first.next = null;
        while(second.next != null){
            ListNode newSecond = second.next;
            second.next = first;
            first = second;
            second = newSecond;
        }
        //最后一个元素next == null跳出循环,将它指向前一个，否则链表会断开
        second.next = first;
        return second;
    }
}
