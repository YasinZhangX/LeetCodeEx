package medium;

import Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import primary.design.Ex2;

/**
 * @author Yasin Zhang
 */
public class LRUCacheTest {

    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\"]";
        String callParams = "[[2],[1/1],[2/2],[1],[3/3],[2],[4/4],[1],[3],[4]]";

        testUtils = new TestUtils(LRUCache.class, callMethods, callParams);
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
