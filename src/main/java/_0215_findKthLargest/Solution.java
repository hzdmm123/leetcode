package _0215_findKthLargest;

import java.util.PriorityQueue;

/**
 * @author hzdmm123
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();

    }
}
