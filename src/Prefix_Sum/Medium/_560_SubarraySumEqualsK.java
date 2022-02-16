package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _560_SubarraySumEqualsK {

    //Time = O(n), Space = O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }


    /*
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return k;
        int n = nums.length;
        int[] preSum = new int[n];
        for(int i=0; i<n; i++) {
            if(i==0) preSum[i] = nums[i];
            else{
                preSum[i] = preSum[i-1] + nums[i];
            }
        }
        for(int a : preSum){
            System.out.println(a);
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int  s : preSum) {
            if(s==k) res++;
            if(map.containsKey(s-k)){
                res += map.get(s-k);
            }
            map.put(s, map.getOrDefault(s, 0)+1);
            //System.out.println(s + " " + k + " " + res);
        }
        return res;
    } */


    /*
     //Time = O(n^2), Space = O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int count = 0;
        for(int start=0; start<n; start++){
            for(int end=start+1; end<=n; end++){
                if(preSum[end]-preSum[start]==k) count++;
            }
        }
        return count;
    }

     */

}
