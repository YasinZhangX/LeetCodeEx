package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class SearchRotatedArrayTest {

    @Test
    public void search() {
        int[] nums = {2,3,4,5,6,7,8,9,1};
        int target = 9;
        SearchRotatedArray alg = new SearchRotatedArray();
        int result = alg.search(nums, target);
        System.out.println(result);
    }
}
