package medium;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class RemoveNthFromEndTest {

    @Test
    public void removeNthFromEnd() {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = null;

        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode ret =  test.removeNthFromEnd(t1, 2);
        System.out.println(ret);
    }
}
