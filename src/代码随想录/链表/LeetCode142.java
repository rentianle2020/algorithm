package 代码随想录.链表;

import java.util.HashSet;

/**
 * 142. 环形链表 II
 */
public class LeetCode142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 另一个方法暂时没看懂
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
