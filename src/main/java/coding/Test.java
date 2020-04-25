package coding;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class Test {
    public ListNode deleteKth(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        ListNode preTarget = new ListNode(0);
        preTarget.next = head;
        ListNode ahead = head;
        ListNode dummy = preTarget;

        for (int t = 0; t < k - 1; t++) {
            if (ahead == null) {
                return head;
            }
            ahead = ahead.next;
        }

        if (ahead == null) {
            return head;
        }

        while (ahead.next != null) {
            preTarget = preTarget.next;
            ahead = ahead.next;
        }

        preTarget.next = preTarget.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Test alg = new Test();
        ListNode head = alg.deleteKth(n0, -1);

        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
        System.out.println();
    }
}
