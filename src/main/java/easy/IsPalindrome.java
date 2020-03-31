package easy;

/**
 * @author Yasin Zhang
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if (s.trim().length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            while (left < right && !isValidChar(str[left])) {
                left++;
            }
            while (right > left && !isValidChar(str[right])) {
                right--;
            }

            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isValidChar(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
    }
}
