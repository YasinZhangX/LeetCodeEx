package medium;

/**
 * @author Yasin Zhang
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        if (num1.length() < num2.length()) {
            String t = num2;
            num2 = num1;
            num1 = t;
        }

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] res = new char[num1.length()+1];
        int overflow = 0;
        int i = 0;
        while (i < num2.length()) {
            int i1 = n1.length - 1 - i;
            int i2 = n2.length - 1 - i;

            int sum = (n1[i1] - '0') + (n2[i2] - '0') + overflow;
            res[num1.length() - i] = (char) (sum % 10 + '0');
            overflow = sum / 10;

            i++;
        }

        while (i < num1.length()) {
            int sum = (n1[n1.length - 1 - i] - '0') + overflow;
            res[num1.length() - i] = (char) (sum % 10 + '0');
            overflow = sum / 10;
            i++;

            if (overflow == 0) {
                while (i < num1.length()) {
                    res[num1.length() - i] = n1[num1.length() - 1 - i];
                    i++;
                }
            }
        }

        res[0] = (char) (overflow + '0');

        if (res[0] == '0') {
            return new String(res, 1, res.length-1);
        } else {
            return new String(res);
        }
    }
}
