package offersword;

import java.util.Arrays;

/**
 * @author Yasin Zhang
 */
public class FindNumsAppearOnce {
    public void solution(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }

        Arrays.sort(array);
        boolean setOne = false;
        int i = 0;
        while (i < array.length && i+1 < array.length) {
            if (array[i] == array[i+1]) {
                i = i + 2;
            } else {
                if (!setOne) {
                    num1[0] = array[i];
                    setOne = true;
                } else {
                    num2[0] = array[i];
                    break;
                }
                i++;
            }
        }

        if (i == array.length - 1) {
            num2[0] = array[i];
        }
    }
}
