package coding.test;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class ZiJIe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    private static long solution(int[] arr) {
        long max = 0;
        int n = arr.length - 1;
        int[] memo = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int L = L(arr, i, memo);
            int R = R(arr, i);
            memo[i] = L;
            max = Math.max((long)L*(long)R, max);
        }

        return max;
    }

    private static int L(int[] arr, int i, int[] memo) {
        int l = i - 1;
        int ans = 0;

        while (l >= 1) {
            if (arr[l] > arr[i]) {
                ans = l;
                break;
            } else if (arr[l] == arr[i]) {
                ans = memo[l];
                break;
            }

            l--;
        }

        return ans;
    }

    private static int R(int[] arr, int i) {
        int r = i + 1;
        int n = arr.length - 1;
        int ans = 0;

        while (r <= n) {
            if (arr[r] > arr[i]) {
                ans = r;
                break;
            }

            r++;
        }

        return ans;
    }
}
