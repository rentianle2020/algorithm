package 多指针.链表;

public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {

        ListNode smaller = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode dummy1 = smaller;
        ListNode dummy2 = greater;

        while(head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            }else{
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        smaller.next = dummy2.next;
        greater.next = null;
        return dummy1.next;
    }
}
