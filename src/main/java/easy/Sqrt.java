package easy;

/**
 * @author Yasin Zhang
 */
public class Sqrt {

    /**
     * 计算器
     * x^(1/2) = e^(0.5 * ln(x))
     */
    public int mySqrt1(int x) {
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long)(ans+1) * (ans+1) <= x ? ans + 1 : ans;  // 相乘注意使用long
    }

    /**
     * 二分查找
     */
    public int mySqrt2(int x) {
        int s = 0;
        int e = x;   // 右端点是x
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if ((long)mid * mid <= x) {  // 相乘结果用long
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }


    /**
     * 牛顿迭代法
     */
    public int mySqrt3(int x) {
        if (x < 2) return x;

        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }

        return (int)x1;
    }
}
