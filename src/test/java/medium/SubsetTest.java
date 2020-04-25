package medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class SubsetTest {

    @Test
    public void subsets() {
        int[] nums = {1, 2, 3};
        Subset alg = new Subset();
        List<List<Integer>> res = alg.subsets(nums);
        System.out.println(res);
    }
}
