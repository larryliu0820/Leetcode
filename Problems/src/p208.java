import java.util.*;

/**
 * Created by Valued Customer on 9/6/2016.
 * 208. Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class p208 {
    class TrieNode {
        boolean isWord;
        TrieNode[] neighbors;
        TrieNode() {
            neighbors = new TrieNode[26];
        }
    }
    TrieNode head;
    /** Initialize your data structure here. */
    public p208() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode itr = head;
        for (char c: word.toCharArray()) {
            if (itr.neighbors[c-'a'] == null)
                itr.neighbors[c-'a'] = new TrieNode();
            itr = itr.neighbors[c-'a'];
        }
        itr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode itr = head;
        for (char c: word.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) return false;
            else itr = itr.neighbors[c-'a'];
        }
        return itr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode itr = head;
        for (char c: prefix.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) return false;
            itr = itr.neighbors[c-'a'];
        }
        return true;
    }
}
