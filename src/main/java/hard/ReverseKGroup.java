package hard;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        return recurseReverse(dummyNode, k);
    }

    private ListNode recurseReverse(ListNode preHead, int k) {
        ListNode preNext = getKthPreNode(preHead, k);
        if (preHead.next == null || preNext == null || preNext.next == null) {
            return preHead.next;
        }

        ListNode head = preHead.next;
        ListNode next = preNext.next;
        ListNode afterHead = k > 2 ? head.next : head;
        preHead.next = next;
        ListNode pre = recurseReverse(next, k);
        reverse(pre, head, next);

        return next;
    }

    private ListNode getKthPreNode(ListNode preHead, int k) {
        ListNode curNode = preHead;

        for (int i = 1; i < k; i++) {
            if (curNode != null) {
                curNode = curNode.next;
            } else {
                break;
            }
        }

        return curNode;
    }

    private ListNode reverse(ListNode stopNext, ListNode startNode, ListNode stopNode) {
        ListNode pre = stopNext;
        ListNode curr = startNode;
        while (curr != stopNext) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /* 理解错题意，以为只需要翻转两个节点
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        return recurseReverse(dummyNode, k);
    }

    private ListNode recurseReverse(ListNode preHead, int k) {
        ListNode preNext = getKthPreNode(preHead, k);
        if (preHead.next == null || preNext == null || preNext.next == null) {
            return preHead.next;
        }

        ListNode head = preHead.next;
        ListNode next = preNext.next;
        ListNode afterHead = k > 2 ? head.next : head;
        preHead.next = next;
        preNext.next = head;
        head.next = recurseReverse(next, k);
        next.next = afterHead;

        return next;
    }

    private ListNode getKthPreNode(ListNode preHead, int k) {
        ListNode curNode = preHead;

        for (int i = 1; i < k; i++) {
            if (curNode != null) {
                curNode = curNode.next;
            } else {
                break;
            }
        }

        return curNode;
    } */
}
