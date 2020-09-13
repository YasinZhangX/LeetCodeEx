package primary.others;

import utils.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class Ex5Test {

    private TestUtils testUtils;

    private String result;

    @Before
    public void before() {
        String callMethods ="[\"isValid\"]";
        String callParams = "[[],[\"}\"]]";
        testUtils = new TestUtils(Ex5.class, callMethods, callParams);
    }

    @After
    public void after() {
        System.out.println(result);
    }

    @Test
    public void isValid() {
        try {
            result = testUtils.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
