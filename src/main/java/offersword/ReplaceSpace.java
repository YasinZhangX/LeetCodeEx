package offersword;

import java.util.Arrays;

/**
 * 替换空格
 * Tips: 在合并数组（包括字符串）时，如果从前往后复制每个数字（或字符）需要重复移动数字（或字符）多次，
 * 那么我们可以考虑从后往前复制，这样就能减少移动的次数，从而提高效率。
 * @author Yasin Zhang
 */
public class ReplaceSpace {
    public String solutionWorse(StringBuffer str) {
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                str.insert(i, "%20");
                len = len + 3 - 1;
                i = i + 3;
                str.deleteCharAt(i);
                i--;
            }
        }

        return str.toString();
    }

    public String solutionBetter(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int spaceNum = 0;

        for (char ch : chars) {
            if (ch == ' ') {
                spaceNum++;
            }
        }

        char[] newChars = Arrays.copyOf(chars, chars.length + spaceNum*2);
        int i = chars.length - 1;
        int j = newChars.length - 1;
        while (i != j) {
            if (chars[i] != ' ') {
                newChars[j--] = chars[i--];
            } else {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
                i--;
            }
        }

        return new String(newChars);
    }
}
