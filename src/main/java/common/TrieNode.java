package common;

import medium.Trie;

/**
 * @author Yasin Zhang
 */
public class TrieNode {
    private final TrieNode[] next = new TrieNode[26];
    private boolean isEnd = false;
    private int childNum = 0;

    public TrieNode[] getNext() {
        return next;
    }

    public TrieNode getNextNode(char ch) {
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
