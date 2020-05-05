package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LongestSubstrWithoutRepeatTest {

    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstrWithoutRepeat test = new LongestSubstrWithoutRepeat();
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }

    @Test
    public void lengthOfLongestSubstring1() {
        LongestSubstrWithoutRepeat test = new LongestSubstrWithoutRepeat();
        System.out.println(test.lengthOfLongestSubstring1(" "));
    }
}
