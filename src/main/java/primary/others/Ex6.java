package primary.others;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 方法1：数学方法，通过等差数列求和
 * 方法2：计算机方法，通过异或消源
 *
 * @author Yasin Zhang
 */
public class Ex6 {

    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = (n-1)*n/2;

        int tmpSum = 0;
        for (int i : nums) {
            tmpSum = tmpSum + i;
        }

        return (sum-tmpSum);
    }

    public int missingNumber2(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ (i ^ nums[i]);
        }

        return result;
    }

}
