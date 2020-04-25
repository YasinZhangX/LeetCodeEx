package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        long size = (long) (Math.pow(2, nums.length));

        List<List<Integer>> result = new ArrayList<>();
        for (long s = 0; s < size; s++) {
            ArrayList<Integer> list = new ArrayList<>();
            long cur = s;
            int bit = 0;
            while (cur != 0) {
                if ((cur & 1) == 1) {
                    list.add(nums[bit]);
                }
                cur = cur >>> 1;
                bit++;
            }
            result.add(list);
        }

        return result;
    }
}
