package hard;

/**
 * @author Yasin Zhang
 */
public class RegularExpressionMatching {
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        if (dp[i][j] != null) {
            dp[i][j] = true;
        }

        boolean ret;
        if (j == p.length()) {
            ret = (i == s.length());
        } else {
            boolean firstMatch = (i < s.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

            if (j+1 < p.length() && p.charAt(j+1) == '*') {
                ret = (dp(i, j+2, s, p) || (firstMatch && dp(i+1, j, s, p)));
            } else {
                ret = firstMatch && dp(i+1, j+1, s, p);
            }
        }

        dp[i][j] = ret;

        return ret;
    }
}
