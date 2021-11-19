package LeetCode热题;

/**
 * 21. 合并两个有序链表
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(-1);
        ListNode dummy = root;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                root.next = l1;
                l1 = l1.next;
            }else{
                root.next = l2;
                l2 = l2.next;
            }
            root = root.next;
        }

        if(l1 == null){
            root.next = l2;
        }else{
            root.next = l1;
        }

        return dummy.next;
    }
}
