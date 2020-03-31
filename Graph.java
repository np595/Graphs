import java.util.*;

class Graph{

    HashMap<Node, ArrayList<Node>> graph;

    public Graph(){
        this.graph = new HashMap<Node, ArrayList<Node>>();
    }

    void addNode(final String nodeVal){
        //Add a new node to the graph
        Node node = new Node(nodeVal);
        
        if(!this.graph.containsKey(nodeVal)){
            this.graph.put(node, new ArrayList<Node>());
        }else{
            System.out.println("Graph already contains Node ");
        }

    }

    void addUndirectedEdge(final Node first, final Node second){
        //Adds undirected edge between first and second node (and vice versa)
        if(this.graph.containsKey(first) && this.graph.containsKey(second)){
            this.graph.get(first).add(second);
            first.adjacentNodes.add(second);
            this.graph.get(second).add(first);
            second.adjacentNodes.add(first);
        }else{
            System.out.println("Graph does not contain Node ");
        }
    }

    void removeUndirectedEdge(final Node first, final Node second){
        //Removes an undirected edge between first and second (and vice versa)
        if(this.graph.containsKey(first) && this.graph.containsKey(second)){
            this.graph.get(first).remove(second);
            first.adjacentNodes.remove(second);
            this.graph.get(second).remove(first);
            second.adjacentNodes.remove(first);
        }else{
            System.out.println("Graph does not contain Node ");
        }
    }

    HashSet<Node> getAllNodes(){
        //returns a set of all Nodes in the graph
        HashSet<Node> set = new HashSet<Node>();
        this.graph.forEach((k,v) -> {
            set.add(k);
        });
        return set;
    }

}