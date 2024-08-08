import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x;
    int y;
    int level;
    
    Point(){}
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "[" + x + "," + y + "," + level + "]";
    }
    
    public boolean equals(Point b){
        return this.x == b.x && this.y == b.y;
    }
    
    public boolean isValid(int a, int b){
        return x >= a && y >= a && x <= b && y <= b;
    }
}
public class StepsByKnight{   
    //Function to find out minimum steps Knight needs to reach target position.
    final int[] row = {-2, -1,  1,  2,  2,  1, -1, -2};
    final int[] col = {-1, -2, -2, -1,  1,  2,  2,  1};
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        boolean[][] vis = new boolean[N+1][N+1];
        Queue<Point> q = new LinkedList<Point>();
        Point start = new Point(KnightPos[0], KnightPos[1]);
        start.level = 0;
        q.add(start);
        vis[start.x][start.y] = true;
        
        Point target = new Point(TargetPos[0], TargetPos[1]);
        if(start.equals(target)) return 0;
        
        Point ans = new Point();
        boolean breaked = false;

        while(!q.isEmpty()){
            Point point = q.poll();
            
            for(int i=0; i<8; i++){
                Point newPoint = new Point(point.x + row[i], point.y + col[i]);
                
                if(!newPoint.isValid(1,N)) continue;
                if(vis[newPoint.x][newPoint.y]) continue;
                
                newPoint.level = point.level+1;
                if(newPoint.equals(target)){
                    breaked = true;
                    ans = newPoint;
                    break;
                }
                if(distance(newPoint,target) <= distance(start,target)+1){
                    q.add(newPoint);
                    vis[newPoint.x][newPoint.y] = true;
                }
            }
            // System.out.println(q);
            if(breaked) break;
        }
        return (ans.level==0)? -1 : ans.level;
    }
    private double distance(Point a, Point b){
        return Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
    }
}
