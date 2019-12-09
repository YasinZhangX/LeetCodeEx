package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class DivideTest {

    @Test
    public void solution1() {
        Divide alg = new Divide();
        int r = alg.solution1(-2147483648, 1);
        System.out.println(r);
    }
}
