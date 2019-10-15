package hard;

/**
 * 1、中位数二分法
 * 2、二分法找规律
 * 3、递归注意边界
 *
 * 核心：中位数是分割点，即寻找值联想到二分查找
 * @author Yasin Zhang
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2= tmp;
            m = nums1.length;
            n = nums2.length;
        }

        int start = 0;
        int end = m;
        int half = (m + n + 1) / 2;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = half - i;

            if (i < m && nums2[j-1] > nums1[i]) {
                start = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                end = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0d;
    }
}
