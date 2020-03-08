package hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LongestValidParenthesesTest {

    @Test
    public void solution() {
        LongestValidParentheses alg = new LongestValidParentheses();
        int length = alg.solution1(")()())");
        Assert.assertEquals(4, length);
    }
}
