package primary.design;

import Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class Ex2Test {

    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"push\",\"push\",\"push\",\"getMin\",\"pop\",\"top\",\"getMin\"]";
        String callParams = "[[],[-2],[0],[-3],[],[],[],[]]";

        testUtils = new TestUtils(Ex2.class, callMethods, callParams);
    }

    @Test
    public void test() {
        try {
            String result = testUtils.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
