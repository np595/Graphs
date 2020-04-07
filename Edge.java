
public class Edge {
    Node adjacentNode;
    int weight;
    boolean visited = false;
    
    Edge(Node adjacent, int weight){
        this.adjacentNode = adjacent;
        this.weight = weight;
    }
    
}