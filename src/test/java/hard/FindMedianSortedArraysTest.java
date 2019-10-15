package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FindMedianSortedArraysTest {

    @Test
    public void findMedianSortedArrays() {
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double mid = test.findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }
}
