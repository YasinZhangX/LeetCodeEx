package medium;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class RemoveNthFromEnd {
    private static int len = 0;
    private static int fromEndIndex = 0;
    private static boolean getNext = false;
    private static boolean getPre = false;
    private static ListNode removeNodeNext;
    private static ListNode removeNodePre;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        len++;

        if (head.next != null) {
            removeNthFromEnd(head.next, n);
        }

        fromEndIndex++;
        if (n == 1) {
            removeNodeNext = null;
            getNext = true;
        }
        if (n == len) {
            removeNodePre = null;
            getPre = true;
        }
        if (!getNext && fromEndIndex == n - 1) {
            removeNodeNext = head;
            getNext = true;
        }
        if (!getPre && fromEndIndex == n + 1) {
            removeNodePre = head;
            getPre = true;
        }

        if (getNext && getPre) {
            if (removeNodePre == null) {
                return removeNodeNext;
            }
            removeNodePre.next = removeNodeNext;
        }

        return head;
    }

    public ListNode dummyAndTwoPointerSolution(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
