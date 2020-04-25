package hard;

import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class ReversePairsTest {

    @Test
    public void reversePairs() {
        int[] nums = {7, 5, 6, 4};
        ReversePairs alg = new ReversePairs();
        System.out.println(alg.reversePairs(nums));
    }
}
