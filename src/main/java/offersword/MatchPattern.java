package offersword;

/**
 * @author Yasin Zhang
 */
public class MatchPattern {
    public boolean match(char[] str, char[] pattern)
    {
        boolean[][] memo = new boolean[str.length + 1][pattern.length + 1];
        memo[str.length][pattern.length] = true;

        for (int i = str.length; i >= 0; i--){
            for (int j = pattern.length - 1; j >= 0; j--){
                boolean curMatch = i < str.length
                    && (pattern[j] == str[i] ||pattern[j] == '.');
                if (j + 1 < pattern.length && pattern[j+1] == '*') {
                    memo[i][j] = memo[i][j+2] || curMatch && memo[i+1][j];
                } else {
                    memo[i][j] = curMatch && memo[i+1][j+1];
                }
            }
        }
        return memo[0][0];
    }
}
