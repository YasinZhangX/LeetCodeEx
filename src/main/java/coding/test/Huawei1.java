package coding.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Huawei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.length() == 1) {
                break;
            }
            if (line.length() != 0) {
                input.add(line);
            }
        }

        String threshold = line;
        String testString = in.nextLine();

        ArrayList<String> result = solution(testString, threshold, input);
        for (String res : result) {
            System.out.println(res);
        }
    }

    private static ArrayList<String> solution(String testString, String threshold, ArrayList<String> input) {
        int t;
        try {
            t = Integer.parseInt(threshold);
        } catch (Exception e) {
            return input;
        }

        if (t <= 1 || t > 9) {
            return input;
        }

        ArrayList<String> res = new ArrayList<>();
        String testStringSpecial = getSpecial(testString, t);
        for (String in : input) {
            String special = getSpecial(in, t);
            if (strStr(special, testStringSpecial)) {
                res.add(in);
            }
        }

        return res;
    }

    private static String getSpecial(String str, int threshold) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';
            if (a < threshold) {
                builder.append(str.charAt(i));
            }
        }

        return builder.toString();

    }

    private static boolean strStr(String t, String s) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0, j = 0;
        int m = t.length(), n = s.length();
        while (i < m && j < n) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == n)
                return true;
        }
        return false;
    }

    public static boolean strstr1(String s1, String s2){
        if (s1.length() < s2.length() || s2.length() == 0) {
            return false;
        }

        int[] next = new int[s2.length()];
        next[0] = -1;
        for (int i = 1, k = -1; i < s2.length(); i++) {
            if (k == -1 || s2.charAt(i - 1) == s2.charAt(k)) {
                k++;
                next[i] = k;
            } else {
                next[i] = 0;
                k = 0;
            }
        }

        for (int i = 0,j = 0; i < s1.length();) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (next[j] == -1) {
                    i++;
                } else {
                    j = next[j];
                }
            } else {
                if (j == s2.length()-1) {
                    return true;
                }
                i++;
                j++;
            }
        }

        return false;
    }

    private static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
