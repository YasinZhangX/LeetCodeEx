package medium;

/**
 * @author Yasin Zhang
 */
public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];
        int[] dp = new int[maxDay + 30 + 1];
        int[] ticketValid = {1, 7, 30};

        int j = days.length - 1;
        for (int i = dp.length - 2; i > 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            if (j < 0 || i != days[j]) {
                dp[i] = dp[i+1];
            } else {
                for (int k = 0; k < 3; k++) {
                    dp[i] = Math.min(dp[i], dp[i + ticketValid[k]] + costs[k]);
                }
                j--;
            }
        }

        return dp[1];
    }
}
