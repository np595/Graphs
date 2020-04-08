import java.util.*;
class Main{
    //4c
    static DirectedGraph createRandomDAGIter(final int n){
        //Creates n random nodes with randomly assigned unweighted, directed edges
        DirectedGraph randomDAG = new DirectedGraph();
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
            randomDAG.addNode(Integer.toString(randomNum));
            i--;
        }
        
        //Get random edges for each node and update nodes, edges will be unweighted and bidirectional
        Set<Node> nodes = randomDAG.getAllNodes();
        Node[] nodesToSelectFrom = new Node[nodes.size()];
        nodes.toArray(nodesToSelectFrom);

        for (Node node : nodes) {
            randomNum = randNumGen.nextInt(n)+1;
            randomDAG.addDirectedEdge(node, nodesToSelectFrom[randomNum-1]);
        }

        return randomDAG;
    }
    
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
            randomGraph.addUndirectedEdge(node, nodesToSelectFrom[randomNum-1]);
        }

        return randomGraph;
    }
    //5c
    static WeightedGraph createdRandomCompleteWeightedGraph(final int n){
        WeightedGraph graph = new WeightedGraph();
        Random randNumGen = new Random();
        int randomNum;
        for(int i = 0; i < n; i++){
            graph.addNode(Integer.toString(i));
        }
        for (Node vertex : graph.vertices) {
            for (Node node : graph.vertices) {
                if(vertex == node){
                    continue;
                }else{
                    randomNum = randNumGen.nextInt(100)+1;
                    graph.addWeightedEdge(vertex, node, randomNum);
                }
            }
        }

        return graph;
    }
    //5d
    static WeightedGraph createWeightedLinkedList(final int n){
        WeightedGraph linkedList = new WeightedGraph();
        for(int i = 0; i < n; i++){
            if(linkedList.vertices.isEmpty()){
                linkedList.addNode(Integer.toString(i));
            }else{
                linkedList.addWeightedEdge(new Node (Integer.toString(i-1)), new Node(Integer.toString(i)), 1);
                linkedList.addNode(Integer.toString(i));
            }
        }
        return linkedList;
    }
    //5e
    static HashMap<Node,Integer> dijsktras(final Node start){
        //Returns dictionary mapping each node in the graph to the minimum value from start to get to this node
        //TODO:test this
        HashMap<Node, Integer> distance = new HashMap<>();
        
        Comparator<Edge> edgeWeightComparator = new Comparator<Edge>(){
        
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.weight < o2.weight){
                    return o1.weight;
                }
                return o2.weight;
            }
        };

        PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>(edgeWeightComparator);
        HashSet<Node> visited = new HashSet<>();
        
        distance.put(start, 0);
        Node cur = start;
        Node min = null;
        
        for (Node neighbor : start.edges.keySet()) {
            distance.put(neighbor, Integer.MAX_VALUE);
        }

        while(cur != null && distance.get(cur) != Integer.MAX_VALUE){
            visited.add(cur);
            for (Node neighbor : cur.edges.keySet()) {
                distance.putIfAbsent(neighbor, Integer.MAX_VALUE); 
                if(!visited.contains(neighbor)){
                    distance.put(neighbor, Math.min( distance.get(neighbor), cur.edges.get(neighbor) + distance.get(cur))); 
                    pQueue.add(new Edge( neighbor, cur.edges.get(neighbor)));
                }

            }
            //get min node
            for (Node node : distance.keySet()) {
                if(!visited.contains(node)){
                    if(min == null){
                        min = node;
                    }else{
                        if(distance.get(node) < distance.get(min)){
                            min = node;
                        }
                    }
                }else{
                    min = null;
                }
              
            }
            cur = min;
        }
        return distance;
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
    static ArrayList<Node> BFTRecLinkedList(final Graph graph){
        ArrayList<Node> BFT = new ArrayList<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        for (Node node : graph.vertices) {
            BFTRecLinkedListHelper(BFT, visited, node);
        }
        
        return BFT;
    }
    private static void BFTRecLinkedListHelper(ArrayList<Node> BFT, HashSet<Node> visited , Node cur){
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
    static ArrayList<Node> BFTIterLinkedList(final Graph graph){
        ArrayList<Node> BFT = GraphSearch.BFTIter(graph);
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
        
        ArrayList<Node> bftLL = BFTIterLinkedList(linkedList);
        ArrayList<Node> bftGraph = GraphSearch.BFTIter(testGraph);
        ArrayList<Node> bftLinkedListRec = BFTRecLinkedList(linkedList);
        System.out.println("Printing BFT on random Graph");
        for (Node node : bftGraph) {
            System.out.println(node.nodeVal);
        }
        System.out.println("Printing BFT on Linked List");
        for (Node node : bftLL) {
            System.out.println(node.nodeVal);
        }
        System.out.println("Printing BFT Recursive Linked List");
        for (Node node : bftLinkedListRec) {
            System.out.println(node.nodeVal);
        }

        WeightedGraph dijk = new WeightedGraph();
        dijk.addNode("a");
        dijk.addNode("b");
        dijk.addNode("c");
        dijk.addNode("d");
        dijk.addNode("e");
        dijk.addNode("f");
        dijk.addNode("g");

        dijk.addWeightedEdge(dijk.vertices.get(0), dijk.vertices.get(1), 2);
        dijk.addWeightedEdge(dijk.vertices.get(0), dijk.vertices.get(3), 4);
        dijk.addWeightedEdge(dijk.vertices.get(0), dijk.vertices.get(3), 7);
        dijk.addWeightedEdge(dijk.vertices.get(0), dijk.vertices.get(5), 5);
        dijk.addWeightedEdge(dijk.vertices.get(1), dijk.vertices.get(4), 3);
        dijk.addWeightedEdge(dijk.vertices.get(1), dijk.vertices.get(1), 3);
        dijk.addWeightedEdge(dijk.vertices.get(1), dijk.vertices.get(6), 8);
        dijk.addWeightedEdge(dijk.vertices.get(2), dijk.vertices.get(5), 6);
        dijk.addWeightedEdge(dijk.vertices.get(3), dijk.vertices.get(6), 6);
        dijk.addWeightedEdge(dijk.vertices.get(4), dijk.vertices.get(6), 7);
        dijk.addWeightedEdge(dijk.vertices.get(5), dijk.vertices.get(6), 6);

        HashMap<Node, Integer> dist = dijsktras(dijk.vertices.get(0));
        System.out.println("Performing dijsktras");
        for (Node node : dist.keySet()) {
            System.out.println("Node "+node.nodeVal+" : " + dist.get(node));
        }
    }
}