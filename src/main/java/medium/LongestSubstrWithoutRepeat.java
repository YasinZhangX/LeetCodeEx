package medium;

import java.util.HashMap;

/**
 * 寻找为了避免重复遍历，可以用滑动窗口，缩减已经处理的部分
 * 为了快速确定位置，通过Hash算法
 * @author Yasin Zhang
 */
public class LongestSubstrWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int maxSubStringSize = 0;
        int start, end;

        HashMap<Character, Integer> charIndex = new HashMap<>();
        for (start = end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (charIndex.containsKey(curChar)) {
                maxSubStringSize = Math.max(maxSubStringSize, end - start);
                start = Math.max(charIndex.get(curChar) + 1, start);
            }

            charIndex.put(curChar, end);
        }

        maxSubStringSize = Math.max(maxSubStringSize, end - start);

        return maxSubStringSize;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] count = new int[128];
        char[] str = s.toCharArray();
        int res = 0;
        int left = 0;
        count[str[left]]++;
        for (int i = 1; i < str.length; i++) {
            count[str[i]]++;

            while (count[str[i]] > 1) {
                count[str[left++]]--;
            }

            res = Math.max(res, i-left+1);
        }

        res = Math.max(res, str.length-left);

        return res;
    }
}
