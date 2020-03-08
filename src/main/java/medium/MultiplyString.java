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
}
