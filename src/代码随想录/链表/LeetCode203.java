package 代码随想录.链表;

/**
 * 203. 移除链表元素
 */
public class LeetCode203 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(6);
        listNode.next = listNode1;
        new LeetCode203().removeElements(listNode, 6);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 画一个图会非常的清晰
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
