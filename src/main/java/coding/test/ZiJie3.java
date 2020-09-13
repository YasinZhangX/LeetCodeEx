package coding.test;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class ZiJie3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    private static long solution(int n, int m, int[] arr) {
        int[] array = new int[n*m];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr, 0, array, n*i, n);
        }

        int[] interval = new int[2];
        return helper(array, interval);
    }

    private static long solution1(int n, int m, int[] arr) {
        int[] arrarr = new int[n*2];
        System.arraycopy(arr, 0, arrarr, 0, n);
        System.arraycopy(arr, 0, arrarr, n, n);

        int[] interval = new int[2];
        long sum = helper(arrarr, interval);
        long ans;
        if (interval[0] < n && interval[1] >= n) {
            ans = sum * (m-1);
            long betweenSum = getSum(arr, interval[1] - n, interval[0]);
            ans = ans + betweenSum * (m - 2);
        } else {
            ans = sum * m;
        }

        return ans;
    }

    private static long getSum(int[] arr, int i, int j) {
        long sum = 0;
        for (int k = i + 1; k < j; k++) {
            sum = sum + arr[k];
        }

        return sum;
    }

    private static long helper(int[] array, int[] interval) {
        if (array == null || array.length == 0) {
            return 0;
        }

        long result = Long.MIN_VALUE;
        int[] tmp = new int[2];
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (sum <= 0) {
                sum = value;
                tmp[0] = i;
            } else {
                sum = sum + value;
                tmp[1] = i;
            }

            if (sum > result) {
                result = sum;
                interval[0] = tmp[0];
                interval[1] = tmp[1];
            }
        }

        return result;
    }
}
