package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MergePartsTest {

    @Test
    public void merge() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeParts alg = new MergeParts();
        alg.merge(intervals);
    }
}
