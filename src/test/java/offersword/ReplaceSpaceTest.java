package offersword;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ReplaceSpaceTest {

    @Test
    public void solutionBetter() {
        ReplaceSpace alg = new ReplaceSpace();
        String str = alg.solutionBetter(new StringBuffer("we are happy"));
        System.out.println(str);
    }
}
