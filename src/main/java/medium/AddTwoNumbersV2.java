package medium;

import common.ListNode;

import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class AddTwoNumbersV2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode cur = l1;
        while(cur != null) {
            s1.push(cur);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            s2.push(cur);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        if (s1.size() < s2.size()) {
            dummy.next = l2;
            Stack<ListNode> t = s2;
            s2 = s1;
            s1 = t;
        }

        int add = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode a = s1.pop();
            ListNode b = s2.pop();
            int sum = a.val + b.val + add;
            a.val = sum % 10;
            add = sum / 10;
        }

        while(!s1.isEmpty() && add != 0) {
            ListNode top = s1.pop();
            int sum = top.val + add;
            top.val = sum % 10;
            add = sum / 10;
        }

        if (add != 0) {
            ListNode newHead = new ListNode(add);
            newHead.next = dummy.next;
            dummy.next = newHead;
        }

        return dummy.next;
    }
}
