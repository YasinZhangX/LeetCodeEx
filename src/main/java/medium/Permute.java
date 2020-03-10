package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * @author Yasin Zhang
 */
public class Permute {
    private int length;

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        length = nums.length;
        int index = 0;
        helper(result, list, index);

        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> list, int index) {
        if (index == length-1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < length; i++) {
            Collections.swap(list, i, index);
            helper(result, list, index+1);
            Collections.swap(list, i, index);
        }
    }
}
