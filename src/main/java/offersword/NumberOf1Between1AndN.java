package offersword;

/**
 * @author Yasin Zhang
 */
public class NumberOf1Between1AndN {
    public int solution(int n) {
        String str = n + "";
        int length = str.length();
        int first = str.charAt(0) - '0';

        if (length == 1) {
            if (first != 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int numsForFirst;
        if (first > 1) {
            numsForFirst = (int) Math.pow(10, length-1);
        } else {
            numsForFirst = Integer.parseInt(str.substring(1)) + 1;
        }

        int numsForRemain = first * (length - 1) * ((int)Math.pow(10, length-2));

        int numsExceptFirst = solution(Integer.parseInt(str.substring(1)));

        return numsForFirst + numsForRemain + numsExceptFirst;
    }
}
