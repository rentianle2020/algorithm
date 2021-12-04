package 多指针.链表;

public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lengthA = 0;
        int lengthB = 0;

        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while(dummyA != null){
            lengthA++;
            dummyA = dummyA.next;
        }

        while(dummyB != null){
            lengthB++;
            dummyB = dummyB.next;
        }

        if(lengthA > lengthB){
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        }else{
            for (int i = 0; i < lengthB - lengthA; i++) {
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
