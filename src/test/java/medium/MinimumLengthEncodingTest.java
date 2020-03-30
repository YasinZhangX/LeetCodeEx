package medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class MinimumLengthEncodingTest {

    @Test
    public void solution() {
        MinimumLengthEncoding alg = new MinimumLengthEncoding();
        String[] words = {"time", "me", "bell"};
        int result = alg.solution(words);
        System.out.println(result);
        Assert.assertEquals(10, result);
    }
}
