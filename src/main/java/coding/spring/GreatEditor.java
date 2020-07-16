package coding.spring;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class GreatEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }

        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chs = strings[i].toCharArray();
            int j = 0;
            while (j < chs.length) {
                sb.append(chs[j]);
                if (j+1 < chs.length && chs[j] == chs[j+1]) {
                    sb.append(chs[j+1]);
                    int s = j+2;
                    while (s < chs.length && chs[j] == chs[s]) {
                        s++;
                    }

                    if (s >= chs.length) {
                        break;
                    }

                    sb.append(chs[s]);
                    int e = s+1;
                    while (e < chs.length && chs[s] == chs[e]) {
                        e++;
                    }
                    j = e;
                } else {
                    j++;
                }
            }
            results[i] = sb.toString();
        }

        for (String s : results) {
            System.out.println(s);
        }
    }
}
