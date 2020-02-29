package offersword;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class IsNumericTest {

    @Test
    public void isNumeric() {
        IsNumeric alg = new IsNumeric();
        assertTrue(alg.isNumeric("123.456e+6".toCharArray()));
    }
}
