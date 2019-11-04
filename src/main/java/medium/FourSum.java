package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int l = 0; l < nums.length; l++) {
            if (l-1 >= 0 && nums[l] == nums[l-1]) {
                continue;
            }

            for (int k = l+1; k < nums.length; k++) {
                if (k - l > 1 && nums[k] == nums[k-1]) {
                    continue;
                }
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[l] + nums[k] + nums[i] + nums[j];
                    if (sum < target) {
                        i++;
                    } else if (sum > target) {
                        j--;
                    } else {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[l]);
                        list.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        resultList.add(list);
                        while (i < j && nums[i + 1] == nums[i]) {
                            i++;
                        }
                        while (i < j && nums[j - 1] == nums[j]) {
                            j--;
                        }
                        i++;
                        j--;
                    }
                }
            }
        }


        return resultList;
    }
}
