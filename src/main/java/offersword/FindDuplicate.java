package offersword;

import java.util.HashMap;

/**
 * 数组中重复的数字
 * @author Yasin Zhang
 */
public class FindDuplicate {
    public boolean solution(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }

        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (dict.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                dict.put(numbers[i], 1);
            }
        }

        return false;
    }
}
