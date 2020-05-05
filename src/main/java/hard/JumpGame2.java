package hard;

/**
 * @author Yasin Zhang
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i+j >= len) {
                    continue;
                }

                dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
                if (i+j == len-1) {
                    return dp[len-1];
                }
            }
        }

        return dp[len-1];
    }

    public int jump_better(int[] nums) {
        int board = 0;
        int maxDistance = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == board) {
                board = maxDistance;
                step++;
                if (board >= nums.length-1) {
                    break;
                }
            }
        }

        return step;
    }
}
