package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class JumpFloorIITest {

    @Test
    public void solution() {
        JumpFloorII alg = new JumpFloorII();
        for (int i = 0; i <= 5; i++) {
            System.out.println("i: " + i + " -- " + alg.solution(i));
        }
    }
}
