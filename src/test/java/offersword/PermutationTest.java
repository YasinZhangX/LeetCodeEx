package offersword;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class PermutationTest {

    @Test
    public void solution() {
        Permutation alg = new Permutation();
        ArrayList<String> result = alg.solution("aa");
        System.out.println(result);
    }
}
