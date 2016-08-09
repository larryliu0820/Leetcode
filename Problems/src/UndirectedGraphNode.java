import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/8/2016.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

}
