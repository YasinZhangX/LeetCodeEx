package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStackRealizeQueueTest {

    @Test
    public void testSolution() {
        TwoStackRealizeQueue alg = new TwoStackRealizeQueue();
        alg.push(1);
        alg.push(2);
        alg.push(3);
        System.out.println(alg.pop());
        System.out.println(alg.pop());
        System.out.println(alg.pop());
        alg.push(4);
        System.out.println(alg.pop());
        alg.push(5);
        System.out.println(alg.pop());
    }
}
