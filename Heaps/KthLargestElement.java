package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a , b) -> a - b);

        for(int i=0; i<k; i++){
            minheap.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            if(nums[i] > minheap.peek()){
                minheap.add(nums[i]);
                minheap.poll();
            }
        }
        return minheap.peek();
    
    }
}
