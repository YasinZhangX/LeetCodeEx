package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class EraseOverlapIntervalsTest {

    @Test
    public void eraseOverlapIntervals() {
        int[][] intervals = {{0,1},{1,2},{3,4}};
        EraseOverlapIntervals alg = new EraseOverlapIntervals();
        int result = alg.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }
}
