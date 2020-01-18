package offersword;

import common.ListNode;

/**
 * @author Yasin Zhang
 */
public class Merge {
    public ListNode solution(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (list1 != null || list2 != null) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if (list1 != null) {
                a = list1.val;
            }
            if (list2 != null) {
                b = list2.val;
            }

            if (a <= b) {
                cur.next = new ListNode(a);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(b);
                list2 = list2.next;
            }

            cur = cur.next;
        }

        return dummyNode.next;
    }
}
