package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LeftRotateStringTest {

    @Test
    public void solution() {
        LeftRotateString alg = new LeftRotateString();
        String str = alg.solution("abcdefg", 2);
        System.out.println(str);
    }
}
