package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FindMinArrowShotsTest {

    @Test
    public void findMinArrowShots() {
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        FindMinArrowShots alg = new FindMinArrowShots();
        int result = alg.findMinArrowShots(points);
        System.out.println(result);
    }
}
