package medium;

/**
 * @author Yasin Zhang
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] str = s.toCharArray();
        int left = 0;
        int right = s.length();
        while (left < right) {
            if (str[left] != str[right]) {
                return isPalindrome(s, left+1, right)
                    || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        char[] str = s.toCharArray();

        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
