package medium;

import common.ListNode;

/**
 * 两数相加1
 * @author Yasin Zhang
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preRet = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode curRet = preRet;
        int overflow = 0;

        while (cur1 != null || cur2 != null) {
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            int sum = x + y + overflow;
            overflow = sum / 10;
            curRet.next = new ListNode(sum % 10);
            curRet = curRet.next;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }

        if (overflow != 0) {
            curRet.next = new ListNode(overflow);
        }

        return preRet.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int add = 0;
        while (cur1 != null || cur2 != null) {
            int n1 = cur1 == null ? 0 : cur1.val;
            int n2 = cur2 == null ? 0 : cur2.val;
            int sum = n1 + n2 + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }

        if (add != 0) {
            cur.next = new ListNode(add);
        }

        return dummy.next;
    }
}

