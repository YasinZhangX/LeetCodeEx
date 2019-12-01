package medium;

import common.ListNode;

import java.util.List;

/**
 * @author Yasin Zhang
 *
 * solution1 使用的递归的解法，每次向下两个节点
 * solution2 使用朴素方式向前推进
 */
public class SwapPairs {
    public ListNode solution1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = solution1(next.next);
        next.next = head;
        return next;
    }

    public ListNode solution2(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            ListNode n1 = curNode.next;
            ListNode n2 = curNode.next.next;
            curNode.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            curNode = n2.next;
        }

        return dummyNode.next;
    }
}
