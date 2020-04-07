import java.util.*;
public class GridNode {
    final int x;
    final int y;
    final String nodeVal;
    ArrayList<GridNode> edges = new ArrayList<GridNode>();
    GridNode(final int x, final int y, final String nodeVal){
        this.x = x;
        this.y = y;
        this.nodeVal = nodeVal;
    }
}