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

    // 类似于合并数组，但不合并只是用指针
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int i_1th = -1;
        int ith = -1;
        int p1 = 0;  // 指向nums1下一个需要判断的点
        int p2 = 0;  // 指向nums2下一个需要判断的点
        for (int i = 0; i <= len / 2; i++) {
            i_1th = ith;
            if (p1 < m && (p2 >= n || nums1[p1] <= nums2[p2])) {
                ith = nums1[p1++];
            } else {
                ith = nums2[p2++];
            }
        }

        if (len % 2 == 0) {
            return (i_1th + ith) / 2.0;
        } else {
            return ith;
        }
    }

    // 通过找第k个数的思路来做
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, m-1, nums2, 0, n-1, left)
            + getKth(nums1, 0, m-1, nums2, 0, n-1, right)) / 2.0;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        } else if (len2 == 0) {
            return nums1[start1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int checkPoint1 = start1 + Math.min(len1, k/2) - 1;
        int checkPoint2 = start2 + Math.min(len2, k/2) - 1;
        if (nums1[checkPoint1] < nums2[checkPoint2]) {
            return getKth(nums1, checkPoint1+1, end1, nums2, start2, end2, k - (checkPoint1 - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, checkPoint2+1, end2, k - (checkPoint2 - start2 + 1));
        }
    }
}
