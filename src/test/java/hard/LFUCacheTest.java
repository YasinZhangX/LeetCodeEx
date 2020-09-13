package hard;

import utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class LFUCacheTest {

    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\"]";
        String callParams = "[[2],[1/1],[2/2],[1],[3/3],[2],[4/4],[1],[3],[4]]";

        String callMethods2 = "[\"put\",\"put\",\"put\",\"put\",\"get\"]";
        String callParams2 = "[[2],[3/1],[2/1],[2/2],[4/4],[2]]";

        String callMethods3 = "[\"put\",\"put\",\"get\",\"put\",\"put\",\"get\"]";
        String callParams3 = "[[2],[2/1],[2/2],[2],[1/1],[4/1],[2]]";

        testUtils = new TestUtils(LFUCache.class, callMethods3, callParams3);
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
