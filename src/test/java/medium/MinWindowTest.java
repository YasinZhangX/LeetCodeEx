package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MinWindowTest {

    @Test
    public void minWindow() {
        MinWindow alg = new MinWindow();
        String result =  alg.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
        String result2 =  alg.minWindow("a", "aa");
        System.out.println(result2);
    }
}
