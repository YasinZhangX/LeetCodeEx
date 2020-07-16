package coding.spring;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class BC3Main2 {
    static int mod = 835672545;
    static long ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        in.nextLine();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }

        if (str.equals("")) {
            for (String word : words) {
                if (word.equals(str)) {
                    ans = 1;
                    break;
                }
            }
        } else {
            helper(str, 0, words);
        }

        System.out.println(ans);
    }

    private static void helper(String str, int index, String[] words) {
        if (index == str.length()) {
            ans = (ans + 1) % mod;
            return;
        }

        for (String word : words) {
            if (str.startsWith(word, index)) {
                if (!word.equals("")) {
                    helper(str, index+word.length(), words);
                } else {
                    ans = (ans + 1) % mod;
                }
            }
        }
    }
}
