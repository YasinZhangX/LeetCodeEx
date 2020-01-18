package medium;

/**
 * @author Yasin Zhang
 */
public class SearchRange {
    public int[] solution(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (result[0] == -1) {
            return result;
        }

        int left = result[0] - 1;
        while (left >= 0 && nums[left] == target) {
            result[0] = left;
            left--;
        }
        int right = result[1] + 1;
        while (right < nums.length && nums[right] == target) {
            result[1] = right;
            right++;
        }

        return result;
    }
}
