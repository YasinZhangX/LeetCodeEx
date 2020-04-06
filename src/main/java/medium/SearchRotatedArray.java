package medium;

/**
 * @author Yasin Zhang
 */
public class SearchRotatedArray {
    public int solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start == 0) {
            return bSearch(nums, 0, nums.length-1, target);
        }

        if (target >= nums[0]) {
            return bSearch(nums, 0, start-1, target);
        } else {
            return bSearch(nums, start, nums.length-1, target);
        }
    }

    private int bSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums[0] <= nums[nums.length-1]) {
            return binarySearch(nums, target, 0, nums.length-1);
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, start-1);
        } else {
            return binarySearch(nums, target, start, nums.length-1);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
