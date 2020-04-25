package medium;

/**
 * @author Yasin Zhang
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null
            || num1.length() == 0 || num2.length() == 0) {
            return "";
        } else if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int resultLen = num1.length() + num2.length();
        int[] result = new int[resultLen];
        for (int i = 0; i < num2.length(); i++) {
            int n2 = num2.charAt(num2.length() - i - 1) - '0';
            for (int j = 0; j < num1.length(); j++) {
                int n1 = num1.charAt(num1.length() - j - 1) - '0';
                int sum = result[resultLen - i - j - 1] + n1 * n2;
                result[resultLen - i - j - 1] = sum % 10;
                result[resultLen - i - j - 2] += sum / 10;
            }
        }

        int start = 0;
        while(result[start] == 0) {
            start++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = start; i < resultLen; i++) {
            str.append(result[i]);
        }

        return str.toString();
    }

    /**
     * 思路相同，索引方向不一样
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int len = num1.length() + num2.length();
        int[] res = new int[len];
        for (int i = len2-1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            for (int j = len1-1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        int startIndex = 0;
        while (res[startIndex] == 0) {
            startIndex++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = startIndex; i < len; i++) {
            builder.append(res[i]);
        }

        return builder.toString();
    }
}
