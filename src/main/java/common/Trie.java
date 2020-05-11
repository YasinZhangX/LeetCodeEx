package common;

/**
 * @author Yasin Zhang
 */
public class Trie {
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        char[] str = word.toCharArray();
        for (char ch : str) {
            cur = cur.addNext(ch);
        }
        cur.setIsEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        char[] str = word.toCharArray();
        for (char ch : str) {
            cur = cur.getNextNode(ch);
            if (cur == null) {
                return false;
            }
        }

        return cur.getIsEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] str = prefix.toCharArray();
        for (char ch : str) {
            cur = cur.getNextNode(ch);
            if (cur == null) {
                return false;
            }
        }

        return true;
    }

    /** Returns the longest prefix in the trie */
    public String getLongestPrefix() {
        TrieNode cur = this.root;
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
