package easy;

import java.util.HashSet;

/**
 * @author Yasin Zhang
 */
public class IsHappyNum {
    public boolean isHappy(int n) {
        HashSet<Integer> done = new HashSet<>();
        while (n != 1 && !done.contains(n)) {
            done.add(n);
            n = next(n);
        }

        return n == 1;
    }

    public boolean isHappy2(int n) {
        // 关键在于找到环
        // 可以用HashSet判断是否有环，也可以直接通过隐式的快慢指针遍历链表的方式实现
        int i = n;
        int j = next(n);
        while (j!=1 && i!=j) {
            i = next(i);
            j = next(next(j));
        }
        return j==1;
    }

    private int next(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            n = n / 10;
            sum = sum + tmp * tmp;
        }
        return sum;
    }
}
