package primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class Ex1 {

    /**
     * Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 我的程序采用StringBuilder的方式组成String，但这样多出了额外的消耗
     * 因此，建议在输出类型较少的情况下，直接硬编码结果即可
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean getFlag = false;
            StringBuilder sb = new StringBuilder();
            if (i%3 == 0) {
                sb.append("Fizz");
                getFlag = true;
            }
            if (i%5 == 0) {
                sb.append("Buzz");
                getFlag = true;
            }
            if (!getFlag) {
                sb.append(i);
            }
            result.add(sb.toString());
        }

        return result;
    }

    /**
     * 结果硬编码
     */
    public List<String> better(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0) {
                result.add("FizzBuzz");
            } else if (i%3 == 0) {
                result.add("Fizz");
            } else if (i%5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

}
