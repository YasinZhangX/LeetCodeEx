package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MinRemoveToMakeValidTest {

    @Test
    public void minRemoveToMakeValid() {
        MinRemoveToMakeValid alg = new MinRemoveToMakeValid();
        String result = alg.minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(result);
    }
}
