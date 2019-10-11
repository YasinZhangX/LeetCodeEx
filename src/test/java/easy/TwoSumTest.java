package easy;

import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class TwoSumTest {

    @Test
    public void twoSumTest() {
        int[] nums = {3,3};
        int target = 6;

        TwoSum test = new TwoSum();
        test.twoSum(nums, target);
    }
}
