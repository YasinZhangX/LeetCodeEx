package primary.others;

import utils.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex4Test {

    private TestUtils testUtils;

    private String result;

    @Before
    public void before() {
        String callMethods ="[\"generate\"]";
        String callParams = "[[],[0]]";

        testUtils = new TestUtils(Ex4.class, callMethods, callParams);
    }

    @After
    public void after() {
        System.out.println(result);
    }

    @Test
    public void generate() {
        try {
            result = testUtils.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
