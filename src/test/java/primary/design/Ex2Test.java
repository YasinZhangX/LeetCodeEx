package primary.design;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class Ex2Test {

    Ex2 ex2 = new Ex2();

    @Before
    public void before() {

    }

    @Test
    public void test() {
        ex2.push(2147483647);
        System.out.println("top: " + ex2.top());
        System.out.println("getMin: " + ex2.getMin());
        ex2.push(-2147483648);
        System.out.println("top: " + ex2.top());
        System.out.println("getMin: " + ex2.getMin());
        ex2.pop();
        System.out.println("getMin: " + ex2.getMin());
    }

}
