package medium;

/**
 * @author Yasin Zhang
 */
public class WayToChange {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] coin = {25, 10, 5, 1};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int c = 0; c < 4; c++) {
            // 每多一种硬币，原方法中就需要将每一个可以实现新硬币的方案结合在一起
            // 即dp[i]+dp[i-coin[c]]
            for (int i = coin[c]; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-coin[c]]) % mod;
            }
        }

        return dp[n];
    }

    public int wayToChange2(int n) {
        int mod = 1000000007;
        int res = 0;
        for (int i = 0; i * 25 <= n; i++) {
            int rest = n - i * 25;
            long max10 = rest / 10;
            long max5 = rest % 10 / 5;
            res = (res + (int) (((max10 + 1) * (max10 + max5 + 1)) % mod)) % mod;
        }

        return res;
    }
}
