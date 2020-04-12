package coding;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class ChangeArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();

        ArrayList<String> result = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            in.nextLine();
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            int left = 0;
            int right = n-1;
            while (left < n && a[left] == b[left]) {
                left++;
            }

            if (left == n) {
                result.add("YES");
                continue;
            }

            while (right >= 0 && a[right] == b[right]) {
                right--;
            }

            if (left > right) {
                result.add("NO");
                continue;
            }

            int k = b[left] - a[left];
            if (k <= 0) {
                result.add("NO");
                continue;
            }
            boolean checked = false;
            for (int i = left; i <= right; i++) {
                if (a[i]+k != b[i]) {
                    checked = true;
                    result.add("NO");
                    break;
                }
            }
            if (!checked) {
                result.add("YES");
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
