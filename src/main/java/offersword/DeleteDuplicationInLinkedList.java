package offersword;

import common.ListNode;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class DeleteDuplicationInLinkedList {
    public ListNode solution(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        HashMap<Integer, ListNode> dict = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
