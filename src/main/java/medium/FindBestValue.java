package medium;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import javax.swing.*;
import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 *
 * 给你一个整数数组 arr 和一个目标值 target，请你返回一个整数 value，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近 target（最接近表示两者之差的绝对值最小）。
 *
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 *
 * @author Yasin Zhang
 */
public class FindBestValue {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;

        // 计算前缀和
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = 0;
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        int ans = 0;
        int minDiff = target;
        int l = 1;
        int r = arr[len-1];
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int curSum = calcCurSum(arr, prefixSum, mid);
            int diff = Math.abs(curSum - target);
            if (diff < minDiff) {
                minDiff = diff;
                ans = mid;
            }

            if (curSum < target) {
                l = mid + 1;
            } else if (curSum > target) {
                r = mid - 1;
            } else {
                break;
            }
        }

        int valueUpDiff = minDiff;
        int valueDownDiff = Math.abs(calcCurSum(arr, prefixSum, ans - 1) - target);

        return valueDownDiff < valueUpDiff ? ans - 1 : ans;
    }

    /**
     * 计算当前 value 对应的和
     */
    private int calcCurSum(int[] arr, int[] prefix, int value) {
        int midIndex = Arrays.binarySearch(arr, value);
        if (midIndex < 0) {
            // mid 不在数组中，找到第一个大于 mid 的下标
            midIndex = -midIndex - 1;
        }

        return prefix[midIndex] + value * (arr.length - midIndex);
    }
}
