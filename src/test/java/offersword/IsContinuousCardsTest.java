package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class IsContinuousCardsTest {

    @Test
    public void solution() {
        IsContinuousCards alg = new IsContinuousCards();
        int[] numbers = {1,3,0,7,0};
        System.out.println(alg.solution(numbers));
    }
}
