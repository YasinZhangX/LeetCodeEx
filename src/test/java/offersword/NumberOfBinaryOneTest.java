package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class NumberOfBinaryOneTest {

    @Test
    public void solution() {
        NumberOfBinaryOne alg = new NumberOfBinaryOne();
        System.out.println(alg.solution(-1));
        System.out.println(test2(-1));
    }

    private int test2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }

            flag = flag << 1;
        }

        return count;
    }
}
