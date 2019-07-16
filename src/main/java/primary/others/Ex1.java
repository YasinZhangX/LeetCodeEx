package primary.others;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * @author Yasin Zhang
 */
public class Ex1 {

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while(n!=0){
            res+=n&1;
            n = n>>>1;
        }
        return res;
    }

}
