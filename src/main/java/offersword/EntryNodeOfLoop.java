package offersword;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class EntryNodeOfLoop {
    public ListNode solution(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return  null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
