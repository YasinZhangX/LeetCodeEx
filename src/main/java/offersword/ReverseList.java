package offersword;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class ReverseList {
    public ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}