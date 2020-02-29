package offersword;

/**
 * @author Yasin Zhang
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        int[] index = new int[1];
        index[0] = 0;

        boolean result = checkInteger(str, index);

        if (index[0] < str.length && str[index[0]] == '.') {
            index[0]++;
            result = checkUnsignedInteger(str, index) || result;
        }

        if ((index[0] < str.length) && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            result = checkInteger(str, index) && result;
        }

        return result && (index[0] == str.length);
    }

    private boolean checkInteger(char[] str, int[] index) {
        if ((index[0] < str.length) && (str[index[0]] == '+' || str[index[0]] == '-')) {
            index[0]++;
        }

        return checkUnsignedInteger(str, index);
    }

    private boolean checkUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length) {
            if (str[index[0]] >= '0' && str[index[0]] <= '9') {
                index[0]++;
            } else {
                break;
            }
        }

        return (index[0] != start);
    }

    public static void main(String[] args) {
        IsNumeric alg = new IsNumeric();
        System.out.println(alg.isNumeric("12e".toCharArray()) + " false");
    }
}
