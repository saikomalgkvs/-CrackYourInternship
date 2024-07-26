package Heaps;

import java.util.PriorityQueue;

class Pair{
    int[] point;
    Double distance;

    Pair(int[] a, double b){
        point = a;
        distance = b;
    }
}
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] closest = new int[k][];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance.compareTo(b.distance));

        for(int[] point : points){
            Double dist = getDistance(point);
            Pair pair = new Pair(point, dist);
            pq.add(pair);
        }
        for(int i=0; i<k; i++){
            closest[i] = pq.poll().point;
        }
        return closest;
    }

    private double getDistance(int[] point){
        return Math.sqrt( Math.pow(point[0],2) + Math.pow(point[1],2 ) );
    }
}
