// Problem link : https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class JobSequencingProblem {
    public int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr, (p1, p2) -> p2.profit - p1.profit);
        
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int totalProfit = 0;
        int countJobs = 0;

        for (int i = 0; i < n; i++) {
            if (countJobs==maxDeadline) break;
            int availableSlot = find(parent, arr[i].deadline);
            if (availableSlot > 0) {
                parent[availableSlot] = find(parent, availableSlot - 1); // Union step
                totalProfit += arr[i].profit;
                countJobs++;
            }
        }
        return new int[]{countJobs, totalProfit};
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}



