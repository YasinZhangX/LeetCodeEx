package medium;

/**
 * LCP 19. 秋叶收藏集
 *
 * @author Yasin Zhang
 */
public class MinimumOperations {

    public int minimumOperations(String leaves) {
        int len = leaves.length();
        char[] leavesChar = leaves.toCharArray();

        int[] dp = new int[3];
        dp[0] = leavesChar[0] == 'y' ? 1 : 0;
        dp[1] = dp[2] = Integer.MAX_VALUE;

        dp[1] = dp[0] + (leavesChar[1] == 'r' ? 1 : 0);
        dp[0] = dp[0] + (leavesChar[1] == 'y' ? 1 : 0);
        for (int i = 2; i < len; i++) {
            dp[2] = Math.min(dp[1], dp[2]) + (leavesChar[i] == 'y' ? 1 : 0);
            dp[1] = Math.min(dp[0], dp[1]) + (leavesChar[i] == 'r' ? 1 : 0);
            dp[0] = dp[0] + (leavesChar[i] == 'y' ? 1 : 0);
        }

        return dp[2];
    }
}
