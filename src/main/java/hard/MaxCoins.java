package hard;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right
 * 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 *     你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author Yasin Zhang
 */
public class MaxCoins {

    /**
     * 动态规划法
     * 状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j 的实现
     */
    public int maxCoins(int[] nums) {
        //避免空指针异常
        if (nums == null) {
            return 0;
        }

        //创建虚拟边界
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;

        //创建dp表
        length = nums2.length;
        int[][] dp = new int[length][length];

        //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length-1];
    }

    /**
     * 回溯法（超时）
     */
    public int maxCoins_backtrace(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int ans = 0;
        int size = nums.length;
        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        numList.add(size, 1);
        numList.add(0, 1);


        for (int i = 1; i <= size; i++) {
            int cur = numList.get(i);
            int left = numList.get(i-1);
            int right = numList.get(i+1);
            numList.remove(i);
            int ret = backtrace(numList);
            ans = Math.max(ans, ret + left * cur * right);
            numList.add(i, cur);
        }

        return ans;
    }

    HashMap<String, Integer> cache = new HashMap<>();

    private int backtrace(LinkedList<Integer> list) {
        if (list.size() == 3) {
            return list.get(1);
        }

        if (cache.containsKey(list.toString())) {
            return cache.get(list.toString());
        }

        int ans = 0;
        int size = list.size() - 2;
        for (int i = 1; i <= size; i++) {
            int cur = list.get(i);
            int left = list.get(i-1);
            int right = list.get(i+1);
            list.remove(i);
            int ret = backtrace(list);
            ans = Math.max(ans, ret + left * cur * right);
            list.add(i, cur);
        }

        cache.put(list.toString(), ans);

        return ans;
    }

    public static void main(String[] args) {
        MaxCoins alg = new MaxCoins();
        int[] nums = {7,9,8,0,7,1,3,5,5,2,3,3};
        int ret = alg.maxCoins(nums);
        System.out.println(ret);
    }
}
