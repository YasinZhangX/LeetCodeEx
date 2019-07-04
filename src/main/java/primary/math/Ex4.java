package primary.math;

/**
 * @author Yasin Zhang
 */
public class Ex4 {

    public int romanToInt(String s) {
        int result = 0;

        int index = 0;
        int processed = 0;
        int length = s.length();

        while (processed >= length || index > length) {

        }

        return result;
    }

    private int getDigit(Character c) {
        int digit;

        switch (c) {
            case 'I':
                digit = 1;
                break;

            case 'X':
                digit = 5;
                break;

            case 'V':
                digit = 5;
                break;

            case 'V':
                digit = 5;
                break;

            case 'V':
                digit = 5;
                break;

            case 'V':
                digit = 5;
                break;

            case 'V':
                digit = 5;
                break;

            default:
                digit = 0;
                break;
        }

        return digit;
    }

}
