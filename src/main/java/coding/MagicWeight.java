package coding;

import java.util.Scanner;

/**
 * 魔法权值
6 2
YXYZ
ZYX
XY
XXZ
XYXX
YZ
 * @author Yasin Zhang
 */
public class MagicWeight {

    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }

        permutation(strs, 0, k);

        System.out.println(result);
    }

    private static void permutation(String[] strs, int start, int k) {
        if (start == strs.length - 1) {
            StringBuilder S = new StringBuilder();
            for (String str : strs) {
                S.append(str);
            }
            judge(S.toString(), k);
        } else {
            for (int i = start; i < strs.length; i++) {
                swap(strs, start, i);
                permutation(strs, start+1, k);
                swap(strs, start, i);
            }
        }
    }

    private static void swap(String[] strs, int i, int j) {
        String t = strs[j];
        strs[j] = strs[i];
        strs[i] = t;
    }

    private static void judge(String str, int k) {
        String S = str + str;
        int count = 0;
        for (int i = 1; i < str.length()+1; i++) {
            if (str.equals(S.substring(i, i+str.length()))) {
                count++;
            }
        }
        if (count == k) {
            result++;
        }
    }
}
