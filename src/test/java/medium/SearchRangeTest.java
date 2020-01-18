package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class SearchRangeTest {

    @Test
    public void solution() {
        SearchRange alg = new SearchRange();
        int[] nums = {5,7,7,8,8,10};
        alg.solution(nums, 8);
    }
}
