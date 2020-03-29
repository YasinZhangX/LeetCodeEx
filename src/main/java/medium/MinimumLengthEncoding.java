package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 单词的压缩编码
 * @author Yasin Zhang
 */
public class MinimumLengthEncoding {
    public int solution(String[] words) {
        int[] merge = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            merge[i] = -1;
        }

        for (int i = 0; i < words.length; i++) {
            if (merge[i] != -1) {
                continue;
            }
            for (int j = i+1; j < words.length; j++) {
                int res = isPartOfEachOther(words, i, j);
                if (res == i) {
                    merge[j] = i;
                    break;
                } else if (res == j) {
                    merge[i] = j;
                    break;
                }
            }
        }

        HashSet<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < merge.length; i++) {
            indexSet.add(getRoot(merge, i));
        }

        int result = 0;
        for (Integer i : indexSet) {
            result = result + words[i].length() + 1;
        }

        return result;
    }

    private int getRoot(int[] merge, int i) {
        if (merge[i] == -1) {
            return i;
        } else {
            return getRoot(merge, merge[i]);
        }
    }

    private int isPartOfEachOther(String[] words, int a, int b) {
        if (words[a].length() < words[b].length()) {
            int t = b;
            b = a;
            a = t;
        }

        String A = words[a];
        String B = words[b];
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt(A.length() - i - 1) != B.charAt(B.length() - i - 1)) {
                return -1;
            }
        }

        return a;
    }

    public int solution_better(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;
    }

    static class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
}
