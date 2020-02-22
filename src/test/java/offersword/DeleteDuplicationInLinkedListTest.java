package offersword;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class DeleteDuplicationInLinkedListTest {

    @Test
    public void deleteDuplication() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l33 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l22;
        l22.next = l3;
        l3.next = l33;
        l33.next = l4;
        l4.next = l5;

        DeleteDuplicationInLinkedList alg = new DeleteDuplicationInLinkedList();
        alg.deleteDuplication(l1);
    }
}
