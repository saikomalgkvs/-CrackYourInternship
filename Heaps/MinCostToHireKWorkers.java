// Problem link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/

package Heaps;
import java.util.*;

class Pair {
    double ratio;
    int quality;

    Pair(double ratio, int quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}
class MinCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        List<Pair> workers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            workers.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }

        Collections.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int totalQuality = 0;
        double result = Double.MAX_VALUE;

        for(Pair worker : workers){
            pq.offer(worker.quality);
            totalQuality += worker.quality;

            if(pq.size() > k) totalQuality -= pq.poll();
            if(pq.size() == k) result = Math.min(result, totalQuality * worker.ratio);
        }
        return result;
    }
}