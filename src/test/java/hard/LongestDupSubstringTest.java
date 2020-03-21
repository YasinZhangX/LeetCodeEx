package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LongestDupSubstringTest {

    @Test
    public void solution() {
        LongestDupSubstring alg = new LongestDupSubstring();
        String result = alg.solution("banana");
        System.out.println(result);
    }
}
