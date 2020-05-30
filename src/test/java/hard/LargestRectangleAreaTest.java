package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LargestRectangleAreaTest {

    @Test
    public void largestRectangleArea() {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleArea alg = new LargestRectangleArea();
        int result = alg.largestRectangleArea(heights);
        System.out.println(result);
    }
}
