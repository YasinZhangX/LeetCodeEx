package medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MaxDistanceInMapTest {

    @Test
    public void solution() {
        MaxDistanceInMap alg = new MaxDistanceInMap();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        int result = alg.solution(grid);
        Assert.assertEquals(2, result);
        int[][] grid2 = {{1,0,0},{0,0,0},{0,0,0}};
        int result2 = alg.solution(grid2);
        Assert.assertEquals(4, result2);
    }
}
