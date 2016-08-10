import java.util.*;

/**
 * Created by mengwliu on 8/9/16.
 * 133. Clone Graph
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

 OJ's undirected graph serialization:

 Nodes are labeled uniquely.
 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

 Visually, the graph looks like the following:

    1
   / \
  /   \
 0 --- 2
      / \
      \_/

 */
public class p133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        UndirectedGraphNode result = copy(node, visited);
        return result;
    }

    public UndirectedGraphNode copy(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
        UndirectedGraphNode rootCopy = new UndirectedGraphNode(root.label);
        visited.put(root, rootCopy);
        List<UndirectedGraphNode> neighborCopy = new ArrayList<>();
        for (UndirectedGraphNode n : root.neighbors) {
            if (!visited.containsKey(n)) {
                UndirectedGraphNode nCopy = copy(n, visited);
                neighborCopy.add(nCopy);
            } else {
                neighborCopy.add(visited.get(n));
            }
        }
        rootCopy.neighbors = neighborCopy;
        return rootCopy;
    }
}
