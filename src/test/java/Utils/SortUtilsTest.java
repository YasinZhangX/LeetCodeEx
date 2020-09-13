package Utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class SortUtilsTest {

    @Test
    public void mergeSort() {
        int[] arr = {5, 4, 3, 2, 1};
        SortUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
