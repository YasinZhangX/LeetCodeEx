package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class JumpGame2Test {

    @Test
    public void jump() {
        JumpGame2 alg = new JumpGame2();
        int[] nums = {2,3,1,1,4};
        System.out.println(alg.jump_better(nums));
    }
}
