package offersword;

import common.ListNode;

/**
 * 链表中倒数第k个结点
 * @author Yasin Zhang
 */
public class FindKthToTail {
    public ListNode solution(ListNode head, int k) {
        if (k == 0) {
            return null;
        }

        ListNode target = head;
        ListNode ahead = head;

        for(int t = 0; t < k-1; t++) {
            if (ahead == null) {
                return null;
            }
            ahead = ahead.next;
        }

        if (ahead == null) {
            return null;
        }

        while (ahead.next != null) {
            target = target.next;
            ahead = ahead.next;
        }

        return target;
    }
}
