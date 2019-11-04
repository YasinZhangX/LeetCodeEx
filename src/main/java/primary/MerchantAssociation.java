package primary;

/**
 * @author Yasin Zhang
 */
public class MerchantAssociation {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        if (k > prices.length / 2)
            return noLimit(prices);

        int[][] hold = new int[k + 1][prices.length];
        int[][] unhold = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            hold[i][0] = -prices[0];

            unhold[i][0] = 0;
            for (int j = 1; j < prices.length; j++) {
                hold[i][j] = Math.max(-prices[j] + unhold[i][j-1], hold[i][j-1]); // Buy or not buy
                unhold[i][j] = Math.max(prices[j] + hold[i][j-1], unhold[i][j-1]); // Sell or not sell
            }
        }

        return unhold[k][prices.length - 1];
    }

    private int noLimit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                max += prices[i + 1] - prices[i];
        }
        return max;
    }
}
