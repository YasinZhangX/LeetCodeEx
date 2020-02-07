package offersword;

/**
 * 第一个只出现一次的字符
 * @author Yasin Zhang
 */
public class FirstNotRepeatingChar {
    public int solution(String str) {
        int[] charIndex = new int['z'-'A'+1];
        int[] counter = new int['z'-'A'+1];
        for (int value : counter) {
            value = 0;
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[chars[i] - 'A'] += 1;
            charIndex[chars[i] - 'A'] = i;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1 && charIndex[i] < result) {
                result = charIndex[i];
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}
