package medium;

/**
 * @author Yasin Zhang
 */
public class Trie {
    TrieNode root;

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
            cur = cur.getNext(ch);
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
            cur = cur.getNext(ch);
            if (cur == null) {
                return false;
            }
        }

        return true;
    }

    static class TrieNode {
        private final TrieNode[] next = new TrieNode[26];
        private boolean isEnd = false;
        private int childNum = 0;

        public TrieNode getNext(char ch) {
            return next[ch - 'a'];
        }

        public TrieNode addNext(char ch) {
            if (next[ch - 'a'] == null) {
                next[ch - 'a'] = new TrieNode();
                childNum++;
            }

            return next[ch - 'a'];
        }

        public int getChildNum() {
            return this.childNum;
        }

        public boolean getIsEnd() {
            return this.isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
