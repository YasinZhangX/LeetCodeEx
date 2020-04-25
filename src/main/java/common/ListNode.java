package common;

/**
 * @author Yasin Zhang
 */
public class ListNode {

    //Definition for singly-linked list.
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }

    public static ListNode generateList(int[] nums) {
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }

        return dummy.next;
    }

    public static String printList(ListNode head) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(head.val);
        ListNode cur = head.next;
        while (cur != null) {
            builder.append(", ");
            builder.append(cur.val);
            cur = cur.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
