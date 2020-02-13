package offersword;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author Yasin Zhang
 */
public class JumpFloor {

    public int Solution(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }

        return Solution(target - 1) + Solution(target - 2);
    }

    public int solution_better(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }

        int[] result = {1, 2};
        for (int i = 3; i <= target; i++) {
            int fibN = result[0] + result[1];

            result[0] = result[1];
            result[1] = fibN;
        }

        return result[1];
    }

}
