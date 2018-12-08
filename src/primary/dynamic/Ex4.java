package primary.dynamic;

public class Ex4 {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        
        int lastRob = nums[0];
        int curRob = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = curRob;
            curRob = Math.max(lastRob + nums[i], curRob);
            lastRob = tmp;
        }
        
        return curRob;
    }
}
