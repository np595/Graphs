import java.util.*;

class Node{

    String nodeVal;
    ArrayList<Node> adjacentNodes = new ArrayList<Node>();
    HashMap<Node,Integer> edges = new HashMap<Node, Integer>();
    
    public Node(final String nodeVal){
        this.nodeVal = nodeVal;
    }
    
    void addEdge(Node destination, int weight){
        this.edges.put(destination,weight);
    }
}