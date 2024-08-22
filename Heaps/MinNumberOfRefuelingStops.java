// Problem link: https://leetcode.com/problems/minimum-number-of-refueling-stops/description/

package Heaps;

import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // priority queue to store fuels of reachable stations. 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int i=0;
        int n = stations.length;
        int maxDistance = startFuel;
        int stops = 0;

        while(maxDistance < target){
            if(i<n && stations[i][0] <= maxDistance){
                pq.add(stations[i++][1]);
            }
            else if(pq.isEmpty()) return -1;
            else{
                maxDistance += pq.poll();
                stops++;
            }
        }

        return stops;
    }
}