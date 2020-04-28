package coding;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class CardReplace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        System.out.println(solution(a, b));
    }

    private static int solution(int[] a, int[] b) {
        int p1 = 0;
        int q1 = 1;
        for (int i = 1; i < a.length; i++) {
            int p2 = Integer.MAX_VALUE;
            int q2 = Integer.MAX_VALUE;
            if (a[i-1] <= a[i] && b[i-1] < b[i]) {
                p2 = Math.min(p1, p2);
                q2 = Math.min(q2, q1+1);
            }
            if (a[i-1] < b[i] && b[i-1] < a[i]) {
                p2 = Math.min(p2, q1);
                q2 = Math.min(q2, p1+1);
            }
            p1 = p2;
            q1 = q2;
        }

        return Math.min(p1, q1);
    }
}
