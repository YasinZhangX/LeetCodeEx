package easy;

import Utils.Print;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MergeArrayTest {

    @Test
    public void merge() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        MergeArray alg = new MergeArray();
        alg.merge(nums1, 3, nums2, 3);
        Print.printInt(nums1);
    }
}
