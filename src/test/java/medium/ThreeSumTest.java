package medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ThreeSumTest {

    @Test
    public void threeSum() {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum test = new ThreeSum();
        List<List<Integer>> result = test.threeSum(nums);
        System.out.println(result);
    }
}
