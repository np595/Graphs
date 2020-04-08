import java.util.*;
public class WeightedGraph {
    ArrayList<Node> vertices;

    WeightedGraph(){
        this.vertices = new ArrayList<Node>();
    }

    void addNode(final String nodeVal){
        this.vertices.add(new Node(nodeVal));
    }

    void addWeightedEdge(final Node first, final Node second, final int edgeWeight){
        //vertices.get(vertices.indexOf(first)).adjacentNodes.add(new Node(second.nodeVal, edgeWeight));
        first.addEdge(second, edgeWeight);
    }

    void removeDirectedEdge(final Node first, final Node second){
        List<Node> edges = this.vertices.get(this.vertices.indexOf(first)).adjacentNodes;
        for (Node edge : edges) {
            if(edge == second){
                edges.remove(edge);
                break;
            }
        }
    }

    HashSet<Node> getAllNodes(){
        return new HashSet<Node>(this.vertices);
    }
}