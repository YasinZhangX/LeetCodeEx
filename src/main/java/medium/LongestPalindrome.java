package medium;

/**
 * @author Yasin Zhang
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String solutionDP(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLeft = 0;
        int maxRight = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[j-1][i+1])) {
                    dp[j][i] = true;
                    if (j-i+1 > maxLen) {
                        maxLeft = i;
                        maxRight = j;
                        maxLen = j - i + 1;
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }

        return s.substring(maxLeft, maxRight+1);
    }

    public static void main(String[] args) {
        LongestPalindrome alg = new LongestPalindrome();
        String result =  alg.solutionDP("aaaa");
        System.out.println(result);
    }
}
