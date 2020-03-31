package easy;

/**
 * 合并两个有序数组
 * @author Yasin Zhang
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        int max;

        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[k] = nums2[j];
                j--;
                k--;
                continue;
            } else if (j == -1) {
                break;
            }

            if (nums1[i] > nums2[j]) {
                max = nums1[i];
                nums1[i] = Integer.MIN_VALUE;
                i--;
            } else {
                max = nums2[j];
                j--;
            }

            nums1[k] = max;
            k--;
        }
    }
}
