package offersword;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class MoreThanHalfNum {
    public int solution(int [] array) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int value : array) {
            int times = 1;
            if (counter.containsKey(value)) {
                times = counter.get(value) + 1;
            }
            counter.put(value, times);

            if (times > array.length / 2) {
                return value;
            }
        }

        return 0;
    }
}
