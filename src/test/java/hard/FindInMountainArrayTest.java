package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FindInMountainArrayTest {

    @Test
    public void findInMountainArray() {
        int[] a = {1,2,3,4,5,3,1};
        FindInMountainArray.MountainArray array = new FindInMountainArray.MountainArray(a);
        FindInMountainArray alg = new FindInMountainArray();
        alg.findInMountainArray(2, array);
    }
}
