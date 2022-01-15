package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _532_K_diffPairsInAArray {
    //Time = O(n), Space = O(n)
    public int findPairs(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a :  nums) map.put(a, map.getOrDefault(a, 0)+1);
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(k>0 && map.containsKey(key+k)){
                res++;
            }else if(k==0 && freq > 1){
                res++;
            }
        }
        return res;
    }

    /*
      //Two Pointer--同向双指针
    //Time = O(n*logn), Space = O(n)
    public int findPairs(int[] nums, int k) {
       int res = 0, n = nums.length;
       Arrays.sort(nums);
       int lo = 0, hi = 1;
       while(lo < n && hi < n){
           if(lo==hi || nums[hi]-nums[lo] < k){
               hi++;
           }else if(nums[hi]-nums[lo] > k){
               lo++;
           }else{
               lo++;
               res++;
               while(lo < n && nums[lo]==nums[lo-1]){
                   lo++;
               }
           }
       }
        return res;
    }
     */

    /* //Time = O(n^2), Space = O(n)
      public int findPairs(int[] nums, int k) {
       int res = 0, n = nums.length;
       Arrays.sort(nums);
       for(int i=0; i<n; i++){
           if(i>0 && nums[i]==nums[i-1]) continue;
           for(int j=i+1; j<n; j++){
               if(j>i+1 && nums[j]==nums[j-1]) continue;
               if(Math.abs(nums[i]-nums[j])==k){
                   res++;
               }
           }
       }
        return res;
    }
     */
}
/*
Method-1: use Map
        Count the elements with Counter
   If k > 0, for each element i, check if i + k exist.
   If k == 0, for each element i, check if count[i] > 1

Method-2
        Two Pointer--同向双指针
        first fix the pointer lo, when the distance < k, we move forward hi pointer;
        when distance > k, we move forward lo pointer.
        when distance == k, we move forward lo, and increase res, and skip repeat number

*/