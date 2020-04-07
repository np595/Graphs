import java.util.*;

public class GridGraph {
    ArrayList<GridNode>vertices;

    GridGraph(){
        this.vertices = new ArrayList<GridNode>();
    }

    void addGridNode(final int x, final int y, final String nodeVal){
        this.vertices.add(new GridNode(x, y, nodeVal));
    }

    void addUndirectedEdge(final GridNode first, final GridNode second){
        if(first.x-1 == second.x && first.y-1 == second.y ){
            //top left neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x-1 == second.x && first.y == second.y){
            //top neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x-1 == second.x && first.y+1 == second.y){
            //top right neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x == second.x && first.y+1 == second.y){
            //right neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x+1 == second.x && first.y+1 == second.y){
            //bottom right neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x+1 == second.x && first.y == second.y){
            //bottom neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x+1 == second.x && first.y-1 == second.y){
            //bottom left neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
        if(first.x == second.x && first.y-1 == second.y){
            //left neighbor
            first.edges.add(second);
            second.edges.add(first);
        }
    }

    void removeUndirectEdge(final GridNode first, final GridNode second){
        first.edges.remove(second);
        second.edges.remove(first);
    }

    HashSet<GridNode> getAllNodes(){
        HashSet<GridNode> set = new HashSet<GridNode>();
        this.vertices.forEach((v) -> {
            set.add(v);
        });
        return set;
    }

}