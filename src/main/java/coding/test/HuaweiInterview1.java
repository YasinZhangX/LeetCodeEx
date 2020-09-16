package coding.test;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class HuaweiInterview1 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<Integer> ans = solution(arr);
        System.out.println(ans);
    }

    private static List<Integer> solution(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                left = i + 1;
                sum = 0;
            } else {
                right = i;
                if (sum > max) {
                    maxLeft = left;
                    maxRight = right;
                    max = sum;
                }
            }
        }

        for (int i = maxLeft; i <= maxRight; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
