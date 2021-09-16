package 代码随想录.链表;

/**
 *
 */
public class 面试题0207 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;

        ListNode A = headA;
        ListNode B = headB;

        while(A != null){
            lengthA++;
            A = A.next;
        }

        while(B != null){
            lengthB++;
            B = B.next;
        }

        int skip;
        if(lengthA > lengthB){
            skip = lengthA - lengthB;
            for (int i = 0; i < skip; i++) {
                headA = headA.next;
            }
        }else{
            skip = lengthB - lengthA;
            for (int i = 0; i < skip; i++) {
                headB = headB.next;
            }
        }
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
