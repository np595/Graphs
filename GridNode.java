import java.util.*;
//Side note, but if you want, you could make things easier and just set a visited value so if the node is visited then just set it to true
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
