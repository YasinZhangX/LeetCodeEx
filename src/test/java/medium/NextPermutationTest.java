package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class NextPermutationTest {

    @Test
    public void nextPermutation() {
        NextPermutation alg = new NextPermutation();
        int[] nums = {1, 3, 2};
        alg.solution(nums);
        System.out.println(nums);
    }
}
