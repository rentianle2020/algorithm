package 剑指offer;

/**
 * 剑指offer 25
 */
public class MergeTwoLists {

    public static void main(String[] args) {


        new MergeTwoLists().mergeTwoLists(null,null);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;

        if(l2 == null) return l1;

        if(l2.val <= l1.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }

    /**
     * while循环
     */

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }

        if(l1 == null){
            pre.next = l2;
        }
        if(l2 == null){
            pre.next = l1;
        }
        return dummyHead.next;
    }
}
