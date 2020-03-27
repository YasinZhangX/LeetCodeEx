package easy;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 按摩师
 * @author Yasin Zhang
 */
public class Massage {
    public int solution(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max((prepre + nums[i]), pre);
            prepre = pre;
            pre = cur;
        }

        return pre;
    }
}
