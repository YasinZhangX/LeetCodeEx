package medium;

import Utils.Print;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class MaxDepthAfterSplitTest {

    @Test
    public void maxDepthAfterSplit() {
        MaxDepthAfterSplit alg = new MaxDepthAfterSplit();
        int[] result = alg.maxDepthAfterSplit("(()())");
        Print.printInt(result);
    }
}
