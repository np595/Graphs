import java.util.*;

class Node{

    String nodeVal;
    int weight;
    ArrayList<Node> adjacentNodes = new ArrayList<Node>();
    
    public Node(final String nodeVal){
        this.nodeVal = nodeVal;
    }

    public Node(final String nodeVal, int weight){
        this.nodeVal = nodeVal;
        this.weight = weight;
    }
}