package DynamicProgramming.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class _1696_JumpGameVI {


    //DP + PriorityQueue:  Time = O(nlogn) Space = O(n)
    //Use map heap to set curMax on the top at every step, monotonic queue
    //Sigle Directin Moving===> Sliding Window  + Heap
    //Sigle Directin Moving===> Monotoinik Stack (keep a decreasing stack)
    //Time = O(n)
    public int maxResult(int[] nums, int k) {
        if(nums==null || k < 0) return 0;
        int n = nums.length;
        //dp[i] : represent the max score we can get ending at index i
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(0);
        for(int i=0; i<n-1; i++){
            //when the window is greater than k, then need to pop in the front
            while(!deq.isEmpty() && i-deq.peekFirst() >= k){
                deq.pollFirst();
            }
            //in order to keep an strictly decreasing stack, we need to remove the
            //last element which is smaller than current element
            while(!deq.isEmpty() && dp[deq.peekLast()] <= dp[i]){
                deq.pollLast();
            }
            deq.addLast(i);
            dp[i+1] = dp[deq.peekFirst()] + nums[i+1];
        }
        return dp[n-1];
    }

    /* Follow Up
     //Sigle Directin Moving===> Monotoinik Stack (keep a decreasing stack)
    //Time = O(n)
    public int maxResult(int[] nums, int k) {
        if(nums==null || k < 0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] = the max score get at index i
        dp[0] = nums[0];
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(0);
        for(int i=0; i<n-1; i++){
            while(!deq.isEmpty() && i-deq.peekFirst() >= k){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && dp[deq.peekLast()] <= dp[i]){
                deq.pollLast();
            }
            deq.addLast(i);
            dp[i+1] = dp[deq.peekFirst()] + nums[i+1];
        }
        return dp[n-1];
    }
     */


    //DP + PriorityQueue:(Compressed) Time = O(nlogn) Space = O(n)
    //Use map heap to set curMax on the top at every step
  /*  public int maxResult(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0) return 0;
        int n = nums.length;
        int score = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        pq.add(new int[]{nums[0], 0});
        for(int i=1; i<n; i++){
            //remove the old (nums[v], v) which is out of range k steps, that is v < i-k
            while(!pq.isEmpty() && pq.peek()[1] < i-k){
                pq.poll();
            }
            score = pq.peek()[0] + nums[i];
            pq.add(new int[]{score, i});
        }
        return score;
    }

   */
}

/*

[10,-5,-2,4,0,3]
     |      |
score[3] = Max(score[0], score[1], score[2]) + 4
Heap:
    score[0] = 10
    score[1] = 5
    score[2] = 8


Monotonik Stack:
      [10,-5,-2,4,0,3]
score  10, 5, 8
dp = {10, 5, 8,....}
deque = {10, 5,}==> pop 5, push 8
deque = {10, 8}
*/
