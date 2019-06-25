package primary.dynamic;

public class Ex2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        
        int cur = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (cur > prices[i]) {
                cur = prices[i];
            } else {
                int tmp = prices[i] - cur;
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        
        return max;
    }
}
