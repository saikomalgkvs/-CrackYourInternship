package Heaps;

import java.util.PriorityQueue;

class FurthestBuildingYouCanReach{
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        int n = heights.length;
        int i=1;
        for( ; i<n; i++){
            int diff = heights[i] - heights[i-1];
            if(diff > 0){
                if(bricks >= diff){
                    queue.add(diff);
                    bricks -= diff;
                }
                else if(ladders > 0){
                    if (!queue.isEmpty() && queue.peek() > diff) {
                        int top = queue.poll();
                        bricks += top - diff;
                        queue.add(diff);
                        ladders--;
                    }
                    else ladders--;
                }
                else break;
                // System.out.println(i + " " + bricks + " " + ladders + " diff: " + diff);
            } 
        }
        return i-1;
    }
}