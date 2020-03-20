package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FindKthLargestTest {

    @Test
    public void findKthLargest() {
        FindKthLargest alg = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};
        int result = alg.findKthLargest(nums, 2);
        System.out.println(result);
    }
}
