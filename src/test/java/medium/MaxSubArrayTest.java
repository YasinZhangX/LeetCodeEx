package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MaxSubArrayTest {

    @Test
    public void maxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray alg = new MaxSubArray();
        System.out.println(alg.maxSubArrayDivideConquer(nums));
    }
}
