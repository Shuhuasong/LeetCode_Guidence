package Queue.Easy;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : nums){
            if(!pq.contains(a)){
                pq.add(a);
            }
            if(pq.size() > 3){
                pq.poll();
            }
        }

        if(pq.size()==3) return pq.peek();
        while(pq.size()>1){
            pq.poll();
        }
        return pq.peek();
    }
}
