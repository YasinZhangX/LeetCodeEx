package medium;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers1() {
        AddTwoNumbers alg = new AddTwoNumbers();
        int[] nums1 = {0,8,6,5,6,8,3,5,7};
        int[] nums2 = {6,7,8,0,8,5,8,9,7};
        ListNode l1 = ListNode.generateList(nums1);
        ListNode l2 = ListNode.generateList(nums2);
        ListNode result = alg.addTwoNumbers1(l1, l2);
        System.out.println(ListNode.printList(result));
    }
}
