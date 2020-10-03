package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MinimumOperationsTest {

    @Test
    public void minimumOperations() {
        MinimumOperations alg = new MinimumOperations();
        String leaves = "rrryyyrryyyrr";
        int result = alg.minimumOperations(leaves);
        System.out.println(result);
    }
}
