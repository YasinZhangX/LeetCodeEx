package coding.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class ZiJie4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr, w));
    }

    int MOD = 1000000007;
    private static int solution(int[] arr, int w) {
        HashSet<int[]> set = new HashSet<>();

        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = w - arr[i];
            if (arr[i] < 0) {
                return 0;
            } else if (arr[i] == 0) {
                if (pre != i) {
                    int[] interval = new int[]{pre, i - 1};
                    set.add(interval);
                    pre = i + 1;
                }
            } else if (arr[i] > 1) {
                return 0;
            }
        }

        return set.size();
    }
}
