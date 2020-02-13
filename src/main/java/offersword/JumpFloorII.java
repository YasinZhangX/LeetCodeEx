package offersword;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Yasin Zhang
 */
public class JumpFloorII {

    public int solution(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        }

        int sum = 1;
        for (int i = target - 1; i >= 0; i--) {
            sum = sum + solution(i);
        }

        return sum;
    }

}
