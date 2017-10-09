import java.util.*;

/**
 * Created by Valued Customer on 7/23/2016.
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the word list
 *
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class p127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordMap = new HashMap<>();
        Map<Integer, Set<Character>> charMap = new HashMap<>();
        for (String word: wordList) {
            wordMap.put(word, 0);
            for (int i = 0; i < word.length(); i++) {
                charMap.putIfAbsent(i, new HashSet<>());
                charMap.get(i).add(word.charAt(i));
            }
        }
        wordMap.put(beginWord, 1);
        wordMap.put(endWord, 0);
        // bfs
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighbors = getNeighbor(wordMap.keySet(), charMap, word);
            for (String neighbor: neighbors) {
                if (wordMap.get(neighbor) == 0) {
                    wordMap.put(neighbor, wordMap.get(word) + 1);
                    queue.offer(neighbor);
                }
            }
        }
        return wordMap.get(endWord);

    }

    private List<String> getNeighbor(Set<String> wordSet, Map<Integer, Set<Character>> charMap, String word) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i+1);
            for (Character c : charMap.get(i)) {
                if (wordSet.contains(prefix+c+suffix)) res.add(prefix+c+suffix);
            }
        }
        return res;
    }
}

