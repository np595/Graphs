import java.util.*;

class Graph{

    ArrayList<Node> vertices;

    public Graph(){
        this.vertices = new ArrayList<Node>();
    }

    void addNode(final String nodeVal){
        //Add a new node to the graph
        Node node = new Node(nodeVal);
        
        if(!this.vertices.contains(node)){
            this.vertices.add(node);
        }else{
            System.out.println("Graph already contains Node ");
        }

    }

    void addUndirectedEdge(final Node first, final Node second){
        //Adds undirected edge between first and second node (and vice versa)
        if(first.adjacentNodes.contains(second) && second.adjacentNodes.contains(first)){
            System.out.println("Nodes are already edges");
        }else{
            first.adjacentNodes.add(second);
            second.adjacentNodes.add(first);
        }
    }

    void removeUndirectedEdge(final Node first, final Node second){
        //Removes an undirected edge between first and second (and vice versa)
        if(first.adjacentNodes.contains(second) && second.adjacentNodes.contains(first)){
            first.adjacentNodes.remove(second);
            second.adjacentNodes.remove(first);
        }else{
            System.out.println("Nodes are not edges with each other");
        }
    }

    HashSet<Node> getAllNodes(){
        //returns a set of all Nodes in the graph
        HashSet<Node> set = new HashSet<Node>();
        this.vertices.forEach((v) -> {
            set.add(v);
        });
        return set;
    }

}