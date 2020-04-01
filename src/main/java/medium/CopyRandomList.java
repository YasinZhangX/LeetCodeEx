package medium;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // duplicate each node
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node dupNode = new Node(cur.val);
            cur.next = dupNode;
            dupNode.next = next;
            cur = next;
        }

        // copy random pointer
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }

        // split list
        cur = head;
        Node dummy = new Node(0);
        dummy.next = cur.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node dup = cur.next;
            cur.next = next;
            if (next != null) {
                dup.next = next.next;
            }

            cur = next;
        }

        return dummy.next;
    }

    static class Node {

        //Definition for singly-linked list.
        public int val;
        public Node next;
        public Node random;

        public Node(int x) {
            val = x;
            next = null;
            random = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
