package coding;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class GoodPlace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        in.nextLine();

        if (n < 3) {
            System.out.println(0);
        }

        int[] places = new int[n];
        for (int i = 0; i < n; i++) {
            places[i] = in.nextInt();
        }

        long cnt = 0;
        int left = 0, right = 2;
        while (right < n) {
            if (places[right] - places[left] > d) {
                left++;
            } else if (right - left < 2) {
                right++;
            } else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= 99997867;
        System.out.println(cnt);
    }

    private static long calC(long num) {
        return num * (num - 1) / 2;
    }

    public static long C(int n, int r)
    {
        if (n < r) {
            return 0;
        }

        int result = 1;
        for (int i = 0; i < n-r; i++) {
            result = result * n;
            n--;
        }

        return result;
    }
}
