package DynamicProgramming.Medium;

import java.util.PriorityQueue;

public class _1696_JumpGameVI {


    //DP + PriorityQueue:  Time = O(nlogn) Space = O(n)
    //Use map heap to set curMax on the top at every step, monotonic queue
    public int maxResult(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        dp[0] = nums[0];
        pq.add(new int[]{nums[0], 0});
        for(int i=1; i<n; i++){
            //remove the old (nums[v], v) which is out of range k steps, that is v < i-k
            while(!pq.isEmpty() && pq.peek()[1] < i-k){
                pq.poll();
            }
            dp[i] = pq.peek()[0] + nums[i];
            pq.add(new int[]{dp[i], i});
        }
        return dp[n-1];
    }


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
