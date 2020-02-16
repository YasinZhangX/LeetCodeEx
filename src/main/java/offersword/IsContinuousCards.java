package offersword;

import java.util.Arrays;

/**
 * @author Yasin Zhang
 */
public class IsContinuousCards {
    public boolean solution(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);
        int superCard = 0;
        int i = 0;
        while (i < numbers.length && numbers[i] == 0) {
            superCard++;
            i++;
        }
        int test = numbers[i++] + 1;
        while (i < numbers.length) {
            if (numbers[i] != test) {
                if (superCard != 0) {
                    superCard--;
                } else {
                    return false;
                }
            } else {
                i++;
            }
            test++;
        }

        return true;
    }
}
