package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(test.maxArea(height));
    }
}
