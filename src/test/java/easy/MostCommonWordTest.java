package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MostCommonWordTest {

    @Test
    public void mostCommonWord() {
        MostCommonWord alg = new MostCommonWord();
        String[] banner = {"hit"};
        String res = alg.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banner);
        System.out.println(res);
    }
}
