package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if (k-1 >= 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    resultList.add(list);
                    while (i < j && nums[i+1] == nums[i]) {
                        i++;
                    }
                    while (i < j && nums[j + 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                }
            }
        }

        return resultList;
    }
}
