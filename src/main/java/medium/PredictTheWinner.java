package medium;

/**
 * @author Yasin Zhang
 */
public class PredictTheWinner {
    public boolean solution_DP(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int pickI = nums[i] - dp[i+1][j];
                    int pickJ = nums[j] - dp[i][j-1];
                    dp[i][j] = Math.max(pickI, pickJ);
                }
            }
        }

        return dp[0][nums.length - 1] >= 0;
    }

    public boolean solution_recurse(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];

        return result(nums, 0, nums.length-1, 1, memo) >= 0;
    }

    private int result(int[] nums, int start, int end, int turn, int[][] memo) {
        if (start == end) {
            return nums[start] * turn;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int pickLeft = nums[start] * turn + result(nums, start+1, end, -turn, memo);
        int pickRight = nums[end] * turn + result(nums, start, end-1, -turn, memo);

        memo[start][end] = Math.max(pickLeft * turn, pickRight * turn) * turn;
        return memo[start][end];
    }
}
