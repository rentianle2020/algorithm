package 代码随想录.链表;

class LeetCode707 {

    public static void main(String[] args) {
        LeetCode707 linkedList = new LeetCode707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,5);
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(1));
    }

    Node head;
    Node tail;
    int length;

    private class Node{
        int val;
        Node next;

        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    public LeetCode707() {
        this.length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = indexNode(index);
        if(node == null) return -1;
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            this.head = new Node(val,null);
            this.tail = head;
        }else{
            this.head = new Node(val,head);
        }
        this.length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(tail == null){
            this.tail = new Node(val,null);
            this.head = tail;
        }else{
            Node newTail = new Node(val,null);
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index == length){
            addAtTail(val);
            return;
        }

        Node pre = indexNode(index - 1);
        Node next = pre.next;
        pre.next = new Node(val,next);
        this.length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length){
            return;
        }
        if(index == 0){
            head = head.next;
            this.length--;
            return;
        }
        Node pre = indexNode(index - 1);
        if(pre.next == tail){
            pre.next = null;
            tail = pre;
        }else{
            pre.next = pre.next.next;
        }
        this.length--;
    }

    public Node indexNode(int index){
        if(index >= length){
            return null;
        }
        Node dummy = new Node(-1,head);
        for(int i = 0; i <= index; i++){
            dummy = dummy.next;
        }
        return dummy;
    }
}
