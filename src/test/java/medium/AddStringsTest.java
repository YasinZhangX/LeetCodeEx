package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class AddStringsTest {

    @Test
    public void addStrings() {
        AddStrings alg = new AddStrings();
        String r1 = alg.addStrings("403", "8");
        assertEquals("411", r1);

        String r2 = alg.addStrings("413", "8");
        assertEquals("421", r2);

        String r3 = alg.addStrings("413", "600");
        assertEquals("1013", r3);
    }
}
