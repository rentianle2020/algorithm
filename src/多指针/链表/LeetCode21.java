package 多指针.链表;

public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            head = head.next;

        }

        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }

        return dummy.next;
    }
}
