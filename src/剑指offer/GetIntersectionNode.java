package 剑指offer;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode;
        listNode2.next = listNode;
        new GetIntersectionNode().getIntersectionNode(listNode1,listNode2);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        //求出A和B链表的长度
        int lenA = 0,lenB = 0;
        while(nodeA != null){
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null){
            lenB++;
            nodeB = nodeB.next;
        }

        //对其开头
        int gap;
        if(lenA > lenB){
            gap = lenA - lenB;
            while(gap-- > 0) {
                headA = headA.next;
            }
        }else{
            gap = lenB - lenA;
            while(gap-- > 0) {
                headB = headB.next;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
