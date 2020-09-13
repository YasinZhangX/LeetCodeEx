package primary.others;

import utils.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex2Test {

    private TestUtils testUtils;

    private String result;

    @Before
    public void before() {
        String callMethods ="[\"hammingDistance\"]";
        String callParams = "[[],[-3/-3]]";

        testUtils = new TestUtils(Ex2.class, callMethods, callParams);
    }

    @After
    public void after() {
        System.out.println(result);
    }

    @Test
    public void hammingDistance() {
        try {
            result = testUtils.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
