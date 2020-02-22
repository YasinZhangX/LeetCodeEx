package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FirstAppearingOnceTest {

    @Test
    public void solution() {
        FirstAppearingOnce alg = new FirstAppearingOnce();
        String str = "google";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            alg.insert(ch);
            System.out.println(alg.solution());
        }
    }
}
