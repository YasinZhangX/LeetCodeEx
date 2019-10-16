package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MyAtoiTest {

    @Test
    public void myAtoi() {
        MyAtoi test = new MyAtoi();
        System.out.println(test.myAtoi("-2147483648"));
    }
}
