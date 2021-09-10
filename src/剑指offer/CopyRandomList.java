package 剑指offer;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> hashMap = new HashMap<>(); //源节点，新节点

        for (Node cur = head;  cur != null ; cur = cur.next) {
            Node node = new Node(cur.val);
            hashMap.put(cur,node);
        }

        for (Node cur = head;  cur != null ; cur = cur.next) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
        }

        return hashMap.get(head);
    }
}
