package LeetCode热题;

/**
 * 2. 两数相加
 */
public class LeetCode2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0 ;

        ListNode root = new ListNode(-1);
        ListNode dummy = root;

        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carry;

            if(sum >= 10) carry = 1;
            else carry = 0;

            root.next = new ListNode(sum);
            root = root.next;
        }

        if (carry == 0) {
            root.next = new ListNode(1);
        }
        return dummy.next;
    }
}
