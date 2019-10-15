package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ZConvertTest {

    @Test
    public void convert() {
        ZConvert test = new ZConvert();
        String result = test.convert("A", 1);
        System.out.println(result);
    }
}
