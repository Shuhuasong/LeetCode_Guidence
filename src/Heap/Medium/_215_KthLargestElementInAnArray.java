package Heap.Medium;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/*
/*
Brute force;
Arrays.sort(nums) ==> get last kth elment

[3,2,3,1,2,4,5,5,6], k = 4

1 2 3 4 5
5 4 3 2 1
*/


