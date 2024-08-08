// Most Stones Removed with Same Row or Column
// Problem link:
// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
import java.util.*;
class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "[" + x + "," + y + "]";
    }
}
class MostStonesRemoved {
    Set<Node> vis;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Map<Node, ArrayList<Node>> map = new HashMap<>();
        vis = new HashSet<>();

        List<Node> points = new ArrayList<Node>();
        for(int[] stone : stones){
            points.add(new Node(stone[0], stone[1]));
        }

        for(int i=0; i<n; i++){
            Node point1 = points.get(i);
            map.put(point1, new ArrayList<>());
            
            for(int j=0; j<n; j++){
                Node point2 = points.get(j);
                if(i!=j && (point1.x == point2.x || point1.y == point2.y)){
                    map.get(point1).add(point2);
                }
            }
        }
        int islands = 0;
        for(Node point : points){
            if(!vis.contains(point)){
                dfs(point, map);
                islands++;
            }
        }
        return n - islands;
    }
    private void dfs(Node point, Map<Node, ArrayList<Node>> map){
        if(vis.contains(point)) return;
        vis.add(point);

        for(Node nextPoint : map.get(point)){
            dfs(nextPoint, map);
        }
    }
}