 import java.util.*;
 class GraphSearch{
    //(d)
    static ArrayList<Node> DFSRec(final Node start, final Node end){
        
        ArrayList<Node> dfsList = new ArrayList<Node>();
        HashSet<Node> visitedNodes = new HashSet<Node>();
        DFSRecHelper(end, visitedNodes, dfsList, start);
        if(dfsList.contains(end)){
            return dfsList;
        }else{
            return null;
        }
    }
    private static void DFSRecHelper(final Node end, HashSet<Node> visited, ArrayList<Node> dfsList , Node current){
        
        visited.add(current);
        dfsList.add(current);

        if(visited.contains(end)){
            return;
        }

        Iterator<Node> adjNodes = current.adjacentNodes.listIterator();
        while(adjNodes.hasNext()){
            Node next = adjNodes.next();
            if(!visited.contains(current)){
                DFSRecHelper(end, visited, dfsList, next);
            }
        }
    }
    //(e)
    ArrayList<Node> DFSIter (final Node start, final Node end){
        
        ArrayList<Node> dfsList = new ArrayList<Node>();
        HashSet<Node> visited = new HashSet<>();

        Stack<Node> processedNodes = new Stack<Node>();
        processedNodes.add(start);
        Node cur;

        while(!processedNodes.empty()){
            cur = processedNodes.pop();
            visited.add(cur);
            dfsList.add(cur);
            if(visited.contains(end)){
                break;
            }
            for (Node node : cur.adjacentNodes) {
                processedNodes.add(node);
            }
        }

        if(visited.contains(end)){
            return dfsList;
        }else{
            return null;
        }
    }
    //(f)
    ArrayList<Node> BFTRec(final Graph graph){
        ArrayList<Node> BFT = new ArrayList<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        for (Node node : graph.getAllNodes()) {
            BFTRecHelper(BFT, visited, node);
        }
        
        return BFT;
    }
    private static void BFTRecHelper(ArrayList<Node> BFT, HashSet<Node> visited , Node cur){
        visited.add(cur);
        BFT.add(cur);
        Iterator<Node> adjNodes = cur.adjacentNodes.listIterator();
        while(adjNodes.hasNext()){
            Node next = adjNodes.next();
            if(!visited.contains(cur)){
                BFTRecHelper(BFT, visited, next);
            }
        }
    }

    //(g)
    static ArrayList<Node> BFTIter(final Graph graph){
        //iteratively returns an ArrayList of all of the Nodes in the Graph in a valid Breadth-First Traversal
        ArrayList<Node> BFT = new ArrayList<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        Node cur;
        for (Node vertex : graph.getAllNodes()) {
            if(!visited.contains(vertex)){
                visited.add(vertex);
                queue.add(vertex);
                while(!queue.isEmpty()){
                    cur = queue.getFirst();
                    queue.remove(cur);
                    BFT.add(cur);
                    visited.add(cur);
                    for (Node adjNode : cur.adjacentNodes) {
                        if(!visited.contains(adjNode)){
                            visited.add(adjNode);
                            queue.add(adjNode);
                        }
                    }     
                }
            }
        }
        return BFT;
    }
    

}