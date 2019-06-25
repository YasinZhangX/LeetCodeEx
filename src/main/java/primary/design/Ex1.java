package primary.design;

import java.util.HashSet;
import java.util.Random;

/**
 * Shuffle an Array
 *
 * @author Yasin Zhang
 */
public class Ex1 {

    private int[] nums;
    private int len;

    public Ex1(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 我的解答基于获取多个不重复的数
     * 更好的方法是通过抽奖思想,数组的每一个位置都相当于从集合中抽取一个数, 见shuffle_best
     */
    public int[] shuffle() {
        int[] result = new int[nums.length];

        int[] tmp = new int[nums.length];  // nums数组下标
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length-i);  // 随机获取数组下标
            result[i] = nums[tmp[index]];       // 获取下标对应的数值
            tmp[index] = tmp[tmp.length-1-i];   // 移除已获取的下标, 已获取下标移动到tmp数组尾部
        }

        return result;
    }

    public int[] shuffle_best() {
        Random random = new Random();
        int[] result = nums.clone();
        for (int i = 0; i < len; i++) {
            int pick = random.nextInt(len);
            // 交换抽到的数和当前位置的数
            int tmp = result[i];
            result[i] = result[pick];
            result[pick] = tmp;
        }

        return result;
    }

}
