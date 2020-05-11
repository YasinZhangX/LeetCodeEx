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

    @Test
    public void longestCommonPrefix_Trie() {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"bb","b"};
        String result = test.longestCommonPrefix_Trie(strs);
        System.out.println(result);
    }
}
