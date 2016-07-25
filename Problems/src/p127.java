import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    class Node {
        String str;
        int distance;
        boolean visited;
        public Node(String str) {
            this.str = str;
            distance = 0;
            visited = false;
        }
        public boolean isOneDifference(Node node) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                char c1 = str.charAt(i);
                char c2 = node.str.charAt(i);
                if (c1 != c2) {
                    diff ++;
                }
            }
            return diff == 1;
        }
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<Node> nodeList = new HashSet<>();
        Node beginNode = new Node(beginWord);
        Node endNode = new Node(endWord);
        nodeList.add(beginNode);
        nodeList.add(endNode);
        for (String word : wordList) {
            if (word == beginWord || word == endWord) continue;
            Node node = new Node(word);
            nodeList.add(node);
        }
        HashMap<Node, HashSet<Node>> adjacencyList = createAdjacencyList(nodeList);
        // BFS
        ArrayList<Node> queue = new ArrayList<>();
        beginNode.distance = 1;
        beginNode.visited = true;
        queue.add(0,beginNode);
        while(!queue.isEmpty()) {
            Node node = queue.remove(0);
            if (adjacencyList.containsKey(node)) {
                for (Node n : adjacencyList.get(node)) {
                    if (!n.visited) {
                        n.distance = node.distance + 1;
                        n.visited = true;
                        queue.add(n);
                    }
                }
            }
        }
        return endNode.distance;
    }
    HashMap<Node, HashSet<Node>> createAdjacencyList (Set<Node> nodeList) {
        HashMap<Node, HashSet<Node>> adjacencyList = new HashMap<>();
        for (Node str1 : nodeList) {
            HashSet<Node> neighbors = new HashSet<>();
            for (Node str2 : nodeList) {
                if (str1.isOneDifference(str2)) {
                    neighbors.add(str2);
                }
            }
            adjacencyList.put(str1, neighbors);
        }
        return adjacencyList;
    }
}

