package offersword;

import common.ListNode;

/**
 * 两个链表的第一个公共结点
 * @author Yasin Zhang
 */
public class FindFirstCommonNode {
    public ListNode solution(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        // 比较长度
        int length1 = getLinkedListLength(pHead1);
        int length2 = getLinkedListLength(pHead2);
        ListNode curLong;
        ListNode curShort;
        int longer;
        if (length1 >= length2) {
            curLong = pHead1;
            curShort = pHead2;
            longer = length1 - length2;
        } else {
            curLong = pHead2;
            curShort = pHead1;
            longer = length2 - length1;
        }

        // 推进长链表指针
        for (int i = 0; i < longer; i++) {
            curLong = curLong.next;
        }

        while(curLong != curShort) {
            curLong = curLong.next;
            curShort = curShort.next;
        }

        return curLong;
    }

    private int getLinkedListLength(ListNode head) {
        int length = 0;

        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }
}
