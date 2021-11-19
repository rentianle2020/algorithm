package LeetCode热题;

/**
 * 160. 相交链表
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(headA != null){
            lengthA++;
            headA = headA.next;
        }

        while(headB != null){
            lengthB++;
            headB = headB.next;
        }

        //更长的链表当作A
        if(lengthB > lengthA){
            ListNode temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;

            int tempLength = lengthA;
            lengthA = lengthB;
            lengthB = tempLength;
        }

        for (int i = 0; i < (lengthA - lengthB); i++) {
            nodeA = nodeA.next;
        }

        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }
}
