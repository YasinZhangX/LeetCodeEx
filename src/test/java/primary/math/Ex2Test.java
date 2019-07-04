package primary.math;

import Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex2Test {

    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"countPrimes\"]";
        String callParams = "[[],[10]]";

        testUtils = new TestUtils(Ex2.class, callMethods, callParams);
    }

    @Test
    public void countPrimes() {
        try {
            String result = testUtils.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
