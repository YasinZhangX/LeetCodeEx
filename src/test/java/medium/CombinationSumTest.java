package medium;

import org.junit.Test;

import java.util.List;

import static java.lang.Math.random;
import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class CombinationSumTest {

    @Test
    public void combinationSum() {
        int start = 40;
        int end = 51;
        int target = 251;
        double test = Math.random()*1e10;
        CombinationSum solution = new CombinationSum();
        List<Long> combinationSum = solution.combinationSum(start, end, target);
        if (combinationSum.size() != 0) {
            System.out.println("YES");
            System.out.print(combinationSum.remove(0) + "");
            for (long i : combinationSum) {
                System.out.print(" " + i);
            }
        } else {
            System.out.println("NO");
        }
    }
}
