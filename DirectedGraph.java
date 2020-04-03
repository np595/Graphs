import java.util.*;
public class DirectedGraph {
    List<Node> vertices;

    DirectedGraph(int n){
        this.vertices = new ArrayList<Node>();
    }

    void addNode(String nodeVal){
        Node node = new Node(nodeVal);
        this.vertices.add(node);
    }

    void addDirectedEdge(final Node first, final Node second){
        //this adds edge from first node to second node but not vice versa!
        first.adjacentNodes.add(second);
    }

    void removeDirectedEdge(final Node first, final Node second){
        //remove the second node from the first node (Removing the edge that links the two)
        first.adjacentNodes.remove(second);
    }

    HashSet<Node> getAllNodes(){
        //return a set of all nodes in the graph
        HashSet<Node> set = new HashSet<Node>();
        this.vertices.forEach((v) -> {
            set.add(v);
        });
        return set;
    }
    
}
