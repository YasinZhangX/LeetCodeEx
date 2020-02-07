package offersword;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * @author Yasin Zhang
 */
public class PrintMinNumber {
    public String solution(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        Arrays.sort(numbers);

        String min = numbers[0] + "";
        for (int i = 1; i < numbers.length; i++) {
            String cur = "" + numbers[i];
            if (Long.parseLong(min + cur) > Long.parseLong(cur + min)) {
                min = cur + min;
            } else {
                min = min + cur;
            }
        }

        return min;
    }
}
