package primary.math;

/**
 * @author Yasin Zhang
 */
public class Ex4 {

    public int romanToInt(String s) {
        int result = 0;

        int length = s.length();
        int index = 0;
        int currentDigit = 0;
        int nextDigit = 0;


        char[] chars = s.toCharArray();
        currentDigit = getDigit(chars[index]);
        while (index < length-1) {
            nextDigit = getDigit(chars[index+1]);

            if (currentDigit < nextDigit) {
                result = result - currentDigit;
            } else {
                result = result + currentDigit;
            }

            index++;
            currentDigit = nextDigit;
        }
        result = result + currentDigit;

        return result;
    }

    private int getDigit(Character c) {
        int digit;

        switch (c) {
            case 'I':
                digit = 1;
                break;

            case 'V':
                digit = 5;
                break;

            case 'X':
                digit = 10;
                break;

            case 'L':
                digit = 50;
                break;

            case 'C':
                digit = 100;
                break;

            case 'D':
                digit = 500;
                break;

            case 'M':
                digit = 1000;
                break;

            default:
                digit = 0;
                break;
        }

        return digit;
    }

}
