package offersword;

/**
 * @author Yasin Zhang
 */
public class LeftRotateString {
    public String solution(String str,int n) {
        if (str == null) {
            return null;
        } else if (str.length() == 0 || n <= 0) {
            return str;
        }

        n = n % str.length();
        char[] chars = str.toCharArray();

        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);

        return new String(chars);
    }

    private void reverse(char[] str, int start, int end) {
        if (start >= end || str == null || str.length == 0) {
            return;
        }

        int mid = (start + end) / 2;
        while(start <= mid) {
            char tmp = str[end];
            str[end] = str[start];
            str[start] = tmp;
            start++;
            end--;
        }
    }
}
