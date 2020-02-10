package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class InversePairsTest {

    @Test
    public void solution() {
        int[] array = {7, 5, 6, 4};
        InversePairs alg = new InversePairs();
        System.out.println(alg.solution(array));
    }
}
