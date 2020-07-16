package coding.spring;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yasin Zhang
 */
public class FindMutiNum {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution (int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        boolean added;
        while (n != 1) {
            added = false;
            for (int i = 2; i <= 9; i++) {
                if (n % i == 0) {
                    n = n / i;
                    factors.add(i);
                    added = true;
                    break;
                }
            }
            if (!added) {
                return -1;
            }
        }
        factors.sort((o1, o2) -> o2 - o1);  // 倒过来，尽量变大

        ArrayList<Integer> bits = new ArrayList<>();
        int index = 0;
        int cur = 1;
        int size = factors.size();
        while (index < size) {
            int tmp = cur * factors.get(index);
            if (tmp > 9) {
                bits.add(cur);
                cur = factors.get(index);
            } else {
                cur = tmp;
            }
            index++;
        }
        bits.add(cur);

        Collections.sort(bits);
        int res = 0;
        for (Integer bit : bits) {
            res = res * 10 + bit;
        }

        return res;
    }

    public static void main(String[] args) {
        FindMutiNum alg = new FindMutiNum();
        int result = alg.solution(108);
        System.out.println(result);
    }
}
