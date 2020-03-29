package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MinIncrementForUniqueTest {

    @Test
    public void solution() {
        MinIncrementForUnique alg = new MinIncrementForUnique();
        int[] A = {3,2,1,2,1,7};
        int result = alg.solution1(A);
        System.out.println(result);
    }
}
