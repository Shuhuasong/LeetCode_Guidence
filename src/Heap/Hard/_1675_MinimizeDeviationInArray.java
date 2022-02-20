package Heap.Hard;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1675_MinimizeDeviationInArray {
    //Time = O(N*logM * logN), N = nums.length, M = max number
    //Space = O(n)
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 1) nums[i] = 2 * nums[i];
            pq.offer(nums[i]);
            min = Math.min(min, nums[i]);
        }
        int res = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            res = Math.min(res, curr-min);
            if(curr%2 == 1) break;
            curr /= 2;
            min = Math.min(min, curr);
            pq.offer(curr);
        }
        return res;
    }
}

/*
devivation = maxV-minV
to decrease the devivation, we either decrease maxV or increase minV
Observation:
1) The only way to make a number bigger is by doubling an odd number(in case the biggest
   number is odd, and we can't decrease it by dividing 2), e.g 5==>10
2) After doubling an odd number, it becomes even, when divide it by 2, we got the original
   number. So no need to double twice, otherwise, we will be in a loop.
3) All even numbers will only smaller if we divide them by 2. Finally an even number
  will become an odd number, no need to double it back.
    e.g   20 => 10 => 5    5=>10

Steps:
1) pre-doubling all the odd numbers, and then only do division to make numbers smaller
   [5, 2, 3] => [10, 4, 6]
2) since only need to make number smaller, we can start from the largest number. And
   compare it with smallest number.
[4, 6, 10] : devivation = 10 - 4 = 6
[4, 5, 6]  : devivation = 6 - 4 = 2
[3, 4, 5] : devivation = 5 - 3
when to stop ? when the largest number become odd, we then stop
*/

