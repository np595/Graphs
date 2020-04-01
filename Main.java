import java.util.*;
class Main{
    static Graph createRandomUnweightedGraphIter(int n){
        //creates n random nodes with randomly assigned unweighted, bidirectional edges
        Graph randomGraph = new Graph();
        Random randNumGen = new Random();
        Set<Integer> randomNumberHash = new HashSet<Integer>();
        int randomNum;
        int i = n;
        //Create random nodes and insert to graph
        while(i != 0){
            //create random node
            randomNum = randNumGen.nextInt(n)+1;
            while(randomNumberHash.contains(randomNum)){
                randomNum = randNumGen.nextInt(n) + 1;
            }
            randomNumberHash.add(randomNum);
            randomGraph.addNode(Integer.toString(randomNum));
            i--;
        }
        
        //Get random edges for each node and update nodes, edges will be unweighted and bidirectional
        Set<Node> nodes = randomGraph.getAllNodes();
        Node[] nodesToSelectFrom = new Node[nodes.size()];
        nodes.toArray(nodesToSelectFrom);

        for (Node node : nodes) {
            randomNum = randNumGen.nextInt(n)+1;
            randomGraph.addUndirectedEdge(node, nodesToSelectFrom[randomNum]);
        }

        return randomGraph;
    }
    static Graph createLinkedList(int n){
        // take a value n and create a linked list of n nodes
        Graph linkedList = new Graph();
        for(int i = 0; i < n ; i++){
            if(linkedList.vertices.isEmpty()){
                linkedList.addNode(Integer.toString(i));
            }else{
                linkedList.addNode(Integer.toString(i));
                linkedList.vertices.get(i-1).adjacentNodes.add(linkedList.vertices.get(i));
            }
        }

        return linkedList;
    }
    //(h)
    ArrayList<Node> BFTRecLinkedList(final Graph graph){
        ArrayList<Node> BFT = new ArrayList<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        for (Node node : graph.getAllNodes()) {
            BFTRecLinkedListHelper(BFT, visited, node);
        }
        
        return BFT;
    }
    private void BFTRecLinkedListHelper(ArrayList<Node> BFT, HashSet<Node> visited , Node cur){
        visited.add(cur);
        BFT.add(cur);
        Iterator<Node> adjNodes = cur.adjacentNodes.listIterator();
        while(adjNodes.hasNext()){
            Node next = adjNodes.next();
            if(!visited.contains(cur)){
                BFTRecLinkedListHelper(BFT, visited, next);
            }
        }
    }
    //(i)
    ArrayList<Node> BFTIterLinkedList(final Graph graph){
        ArrayList<Node> BFT = new ArrayList<Node>();

        return BFT;
    }
    public static void main(String[] args){
        
        /*
        Graph testGraph = new Graph();
        String[] friends = {"Aaron","Collin","Alexis","Connor","Tom","Matt","Steven"};

        for (String friend : friends) {
            testGraph.addNode(friend);
        }
        
        HashSet<Node> friendSet = testGraph.getAllNodes();
        for(Node friend: friendSet){
            System.out.println(friend.nodeVal);
        }
        */
        Graph testGraph = createRandomUnweightedGraphIter(10);
        Graph linkedList = createLinkedList(10);
    }
}