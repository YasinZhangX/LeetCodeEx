package primary.others;

import Utils.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex1Test {

    private TestUtils testUtils;

    private String result;

    @Before
    public void before() {
        String callMethods ="[\"hammingWeight\",\"hammingWeight2\"]";
        String callParams = "[[],[-3],[-3]]";

        testUtils = new TestUtils(Ex1.class, callMethods, callParams);
    }

    @After
    public void after() {
        System.out.println(result);
    }

    @Test
    public void hammingWeight() {
        try {
            result = testUtils.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
