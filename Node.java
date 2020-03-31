import java.util.*;

class Node{

    String nodeVal;
    ArrayList<Node> adjacentNodes = new ArrayList<Node>();

    public Node(final String nodeVal){
        this.nodeVal = nodeVal;
    }

}