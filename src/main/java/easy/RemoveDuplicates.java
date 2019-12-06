package easy;

/**
 * 26. 删除排序数组中的重复项
 *
 * @author Yasin Zhang
 */
public class RemoveDuplicates {
    public int solution(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if (i > 0 && nums[i-1] == nums[i]) {
                i++;
                continue;
            }
            nums[j] = nums[i];
            i++;
            j++;
        }

        return j;
    }
}
