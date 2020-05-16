package hard;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        dummyNode.next = reverseHelper(dummyNode, k);

        return dummyNode.next;
    }

    private ListNode reverseHelper(ListNode preHead, int k) {
        ListNode groupEnd = getGroup(preHead, k);
        if (groupEnd == null) {
            return preHead.next;
        }

        ListNode groupOldHead = preHead.next;
        ListNode groupNewHead = reverseGroup(preHead.next, groupEnd);
        preHead.next = groupNewHead;
        preHead = groupOldHead;
        reverseHelper(preHead, k);

        return groupNewHead;
    }

    private ListNode getGroup(ListNode preHead, int size) {
        ListNode cur = preHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (cur == null) {
                break;
            }
        }

        return cur;
    }

    private ListNode reverseGroup(ListNode startNode, ListNode stopNode) {
        ListNode outGroupNode = stopNode.next;
        ListNode pre = stopNode.next;
        ListNode cur = startNode;
        while (cur != outGroupNode) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return stopNode;
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
