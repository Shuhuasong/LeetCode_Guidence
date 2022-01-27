package Tree.Easy;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _703_KthLargestElementInAStream {
    PriorityQueue<Integer> pq;
    int k;
    public _703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
/*
    Add    nums           res = size-k
        2, 4, 5, 8
        3    2, 3, 4, 5, 8      5-3= 2
        5    2, 3, 4, 5, 5, 8   6-6 = 3
        10   2, 3, 4, 5, 5, 8
*/
