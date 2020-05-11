package easy;

import common.Trie;
import common.TrieNode;

/**
 * @author Yasin Zhang
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int mid) {
        String tmp = strs[0].substring(0, mid);
        for (String str : strs) {
            if (!str.startsWith(tmp)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix_Trie(String[] strs) {
        Trie trie = new Trie();
        for (String word : strs) {
            trie.insert(word);
        }

        return getLongestPrefix(trie);
    }

    private String getLongestPrefix(Trie trie) {
        TrieNode cur = trie.root;
        StringBuilder builder = new StringBuilder();
        while (cur.getChildNum() == 1 && !cur.getIsEnd()) {
            TrieNode[] curNext = cur.getNext();
            for (int i = 0; i < 26; i++) {
                if (curNext[i] != null) {
                    builder.append((char)('a' + i));
                    cur = curNext[i];
                    break;
                }
            }
        }
        return builder.toString();
    }
}
