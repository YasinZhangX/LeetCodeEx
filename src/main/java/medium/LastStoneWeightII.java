package medium;

/**
 * @author Yasin Zhang
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int value : stones) {
            sum += value;
        }

        int capacity = sum / 2;
        int[] dp = new int[capacity+1];
        for (int stone : stones) {
            for (int j = capacity; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return sum - dp[capacity] * 2;
    }
}
