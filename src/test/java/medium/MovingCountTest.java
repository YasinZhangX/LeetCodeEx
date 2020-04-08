package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MovingCountTest {

    @Test
    public void movingCount() {
        MovingCount alg = new MovingCount();
        int result = alg.movingCount(16, 8, 4);
        System.out.println(result);
    }
}
