package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MatchPatternTest {

    @Test
    public void match() {
        MatchPattern alg = new MatchPattern();
        System.out.println(alg.match("abc".toCharArray(), "abc".toCharArray()));
    }
}
