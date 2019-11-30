package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        String result = test.longestCommonPrefix(strs);
        System.out.println(result);
    }
}
