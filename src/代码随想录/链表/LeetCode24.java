package 代码随想录.链表;

/**
 * 24. 两两交换链表中的节点
 */
public class LeetCode24 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode begin = dummy;
        while(begin.next != null && begin.next.next != null){
            ListNode mid = begin.next;
            ListNode end = mid.next;
            begin.next = end;
            mid.next = end.next;
            end.next = mid;

            begin = mid;
        }
        return dummy.next;
    }

}
