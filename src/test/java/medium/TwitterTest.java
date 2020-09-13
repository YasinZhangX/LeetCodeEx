package medium;

import utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class TwitterTest {
    private TestUtils testUtils;

    @Before
    public void before() {
        String callMethods ="[\"postTweet\",\"getNewsFeed\",\"follow\",\"getNewsFeed\",\"unfollow\",\"getNewsFeed\"]";
        String callParams = "[[],[1/1],[1],[2/1],[2],[2/1],[2]]";

        testUtils = new TestUtils(Twitter.class, callMethods, callParams);
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
