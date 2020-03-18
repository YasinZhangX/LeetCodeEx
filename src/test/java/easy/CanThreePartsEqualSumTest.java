package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class CanThreePartsEqualSumTest {

    @Test
    public void solution() {
        CanThreePartsEqualSum alg = new CanThreePartsEqualSum();
        int[] A = {6,1,1,13,-1,0,-10,20};
        System.out.println(alg.solution(A));
    }
}
