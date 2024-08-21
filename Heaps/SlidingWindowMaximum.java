// Problem link: https://leetcode.com/problems/sliding-window-maximum/description/

package Heaps;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0; // index to fill result

        Deque<Integer> deque = new LinkedList<>();
        for(int idx = 0; idx < n; idx++){
            int num = nums[idx];

            while(!deque.isEmpty() && deque.peekLast() < num){
                deque.pollLast();
            }
            deque.addLast(num);

            if(idx >= k && nums[idx - k] == deque.peekFirst()) deque.pollFirst();
            if(idx >= k - 1) result[i++] = deque.peekFirst();
        }
        return result;
    }
}
