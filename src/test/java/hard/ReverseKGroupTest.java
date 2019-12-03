package hard;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ReverseKGroupTest {

    @Test
    public void reverseKGroup() {
        ReverseKGroup alg = new ReverseKGroup();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        System.out.println(alg.reverseKGroup(n1, 2));
    }
}
