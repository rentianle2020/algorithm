package 多指针.链表;

public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {

        if(head == null) return null;

        ListNode evenHead = head.next;
        ListNode dummyEven = evenHead;
        ListNode dummyHead = head;

        while(evenHead != null && evenHead.next != null){
            head.next = evenHead.next;
            head = head.next;

            evenHead.next = head.next;
            evenHead = evenHead.next;
        }

        head.next = dummyEven;
        return dummyHead;
    }
}
