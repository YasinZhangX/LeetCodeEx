package coding;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class BC3Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        in.nextLine();

        char[] str = s.toCharArray();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] params = line.split(" ");
            int opra = Integer.parseInt(params[0]);
            if (opra == 1) {
                int pos = Integer.parseInt(params[1]);
                char c = params[2].charAt(0);
                change(str, pos, c);
            } else if (opra == 2) {
                int l = Integer.parseInt(params[1]);
                int r = Integer.parseInt(params[2]);
                calc(str, l, r);
            }
        }
    }

    public static void change(char[] str, int pos, char c) {
        str[pos] = c;
    }

    public static void calc(char[] str, int l, int r) {
        HashSet<Character> set = new HashSet<>();
        if (l < 1) {
            l = 1;
        }
        if (r > str.length) {
            r = str.length;
        }

        for (int i = l; i <= r; i++) {
            set.add(str[i-1]);
        }

        System.out.println(set.size());
    }
}
