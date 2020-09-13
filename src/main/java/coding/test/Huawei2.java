package coding.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] strs = line.split(";");
        String origin = strs[0];
        String ans = strs[1];

        ArrayList<String> originWords = splitToWords(origin);
        ArrayList<String> ansWords = splitToWords(ans);
        int len = ansWords.size();
        int distance = minDistance(originWords, ansWords);

        System.out.println("(" + distance + "," + len + ")");
    }

    private static ArrayList<String> splitToWords(String str) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            char cur = str.charAt(i);
            if (cur == ' ') {
                i++;
                continue;
            }

            if (cur == ',' || cur == '.' || cur == '!') {
                words.add(".");
                i++;
                continue;
            } else if (cur == '?') {
                words.add("?");
                i++;
                continue;
            }

            StringBuilder builder = new StringBuilder();
            while (str.charAt(i) != ' ' && str.charAt(i) != ','
                && str.charAt(i) != '.' && str.charAt(i) != '!' && str.charAt(i) != '?') {
                builder.append(str.charAt(i));
                i++;
            }
            words.add(builder.toString());
        }

        return words;
    }

    private static int minDistance(ArrayList<String> origin, ArrayList<String> ans) {
        int[][] dp = new int[origin.size()+1][ans.size()+1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (origin.get(i-1).equals(ans.get(j-1))) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1, dp[i-1][j]+1), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1, dp[i-1][j]+1), dp[i-1][j-1]+2);
                }
            }
        }

        return dp[origin.size()][ans.size()];
    }
}
