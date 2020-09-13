package primary.math;

import utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex1Test {

    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"fizzBuzz\"]";
        String callParams = "[[],[15]]";

        testUtils = new TestUtils(Ex1.class, callMethods, callParams);
    }

    @Test
    public void fizzBuzz() {
        try {
            String result = testUtils.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
