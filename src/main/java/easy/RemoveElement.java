package easy;

/**
 * 27. 移除元素
 *
 * @author Yasin Zhang
 */
public class RemoveElement {
    public int solution(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if (nums[i] == val) {
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
