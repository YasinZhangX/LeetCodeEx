package easy;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @author Yasin Zhang
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && toDigit(s.charAt(i)) < toDigit(s.charAt(i+1))) {
                result = result - toDigit(s.charAt(i)) + toDigit(s.charAt(i+1));
                i++;
            } else {
                result = result + toDigit(s.charAt(i));
            }
        }

        return result;
    }

    private int toDigit(char c) {
        switch (c) {
            case 'I':
                return 1;

            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;

            default:
                return 0;
        }
    }
}
