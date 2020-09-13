package medium;

import utils.Print;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class SortArrayTest {

    @Test
    public void sortArray() {
        int[] nums = {5,4,3,2,1};
        SortArray alg = new SortArray();
        alg.sortArray(nums);
        Print.printInt(nums);
    }
}
