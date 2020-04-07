import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
public class TopSort {

    ArrayList<Node> Kahns(final DirectedGraph graph){
        //Performs topological sort using Kahn's algorithm 
        ArrayList<Node> output = new ArrayList<Node>();
        HashMap<Node,AtomicLong> dependencies = new HashMap<Node, AtomicLong>();
        LinkedList<Node> queue = new LinkedList<Node>();
        HashSet<Node> setOfAllNodes = graph.getAllNodes();

        for (Node node : setOfAllNodes) {
            //update dependencies hash map to proper in degree.
            for (Node adjNode : node.adjacentNodes) {
                dependencies.putIfAbsent(adjNode, new AtomicLong(0));
                dependencies.get(adjNode).incrementAndGet();
            }
        }

        for (Node node : setOfAllNodes) {
            if(dependencies.get(node) == null){
                queue.add(node);
            }
        }

        Node e;
        while(!queue.isEmpty()){
            e = queue.peek();
            output.add(e);
            for (Node node : setOfAllNodes) {
                if(node.adjacentNodes.contains(e)){
                    //update in-degree
                    dependencies.get(node).decrementAndGet();
                }
            }
            dependencies.get(e).decrementAndGet();
            AtomicLong zero = new AtomicLong(0);
            for (Node neighbor : e.adjacentNodes) {
                if(dependencies.get(neighbor) == zero){
                    queue.add(neighbor);
                }
            }
            queue.remove(e);
        }

        return output;
    }
    ArrayList<Node> mDFS(final DirectedGraph graph){
        //performs topological sort using modified DFS algorithm
        ArrayList<Node> topoMDFS = new ArrayList<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        for (Node node : graph.getAllNodes()) {
                if(!visited.contains(node)){
                    DFSHelper(node, topoMDFS , visited);
                }
        }

    
        return topoMDFS;
    }
    
    private void DFSHelper(Node v, ArrayList<Node> stack, HashSet<Node> visited){
        visited.add(v);
        for (Node neighbor : v.adjacentNodes) {
            if(!visited.contains(neighbor)){
                DFSHelper(neighbor, stack, visited);
            }
        }

        stack.add(v);
    }
}