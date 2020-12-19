package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    //HashMap
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[]{ map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return   new int[]{-1, -1};
    }

    //Two Pointer
  /*  public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int[] result = new int[2];
        int r = 0;
        for(int l=0; l<n; l++){
            r = l+1;
            while(r<n && nums[l]+nums[r] != target){
                r++;
            }
            if( r<n && nums[l]+nums[r] == target){
                return new int[]{l, r};
            }
        }
        return new int[]{-1, -1};
    }

   */
}
