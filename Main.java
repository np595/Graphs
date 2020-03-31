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
        Graph linkedList = new Graph();
        Node prev;
        for(int i = 0; i < n ; i++){
            if(linkedList.graph.isEmpty()){
                linkedList.addNode(Integer.toString(i));
            }else{
                linkedList.addNode(Integer.toString(i));
                Node curVertex = new Node(Integer.toString(i));
                prev = linkedList.graph.get(Integer.toString(i-1));
                prev.adjacentNodes.add(curVertex);
            }
        }

        return linkedList;
    }
    ArrayList<Node> BFTRecLinkedList(final Graph graph){
        return null;
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