package easy;

/**
 * @author Yasin Zhang
 */
public class SearchInsert {
    public int solution(int[] nums, int target) {
        int result = nums.length;
        if (nums[nums.length-1] < target) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                result = i;
                break;
            }
        }

        return result;
    }
}
