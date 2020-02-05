package offersword;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class MoreThanHalfNum {
    public int solution(int [] array) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int times = 1;
            if (counter.containsKey(array[i])) {
                times = counter.get(array[i]) + 1;
            }
            counter.put(array[i], times);

            if (times > array.length/2) {
                return array[i];
            }
        }

        return 0;
    }
}
