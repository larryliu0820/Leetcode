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
        // Initialize your data structure here.
        Map<String, TrieNode> children;
        String value;
        public TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public p208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int i = 0;
        TrieNode node = root;
        while (i++ < word.length()) {
            if (!node.children.containsKey(word.substring(i,i+1))) {
                node.children.put(word.substring(i,i+1), new TrieNode());
            }
            node = node.children.get(word.substring(i,i+1));
        }
        node.value = word;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int i = 0;
        TrieNode node = root;
        while (i < word.length()) {
            if (!node.children.containsKey(word.substring(i,i+1))) {
                return false;
            }
            node = node.children.get(word.substring(i,i+1));
            i++;
        }
        return node.value != null && node.value.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int i = 0;
        TrieNode node = root;
        while (i < prefix.length()) {
            if (!node.children.containsKey(prefix.substring(i,i+1))) {
                return false;
            }
            node = node.children.get(prefix.substring(i,i+1));
            i++;
        }
        return !node.children.isEmpty() || node.value.equals(prefix);
    }
}
