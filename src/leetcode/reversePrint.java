package leetcode;

import java.util.Stack;

/**
 * 剑指offer 06
 */
public class reversePrint {

    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     *栈实现
     */
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        Stack<ListNode> stack = new Stack<>();
        int length = 0;
        while(head != null){
            stack.push(head);
            length++;
            head = head.next;
        }
        int[] ints = new int[length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }

    public int[] reversePrint2(ListNode head) {
        int length = 0;
        ListNode originalHead = head;
        while(head != null){
            length++;
            head = head.next;
        }

        int[] ints = new int[length];
        for (int i = ints.length - 1; i >= 0 ; i--) {
            ints[i] = originalHead.val;
            originalHead = originalHead.next;
        }
        return ints;
    }
}
