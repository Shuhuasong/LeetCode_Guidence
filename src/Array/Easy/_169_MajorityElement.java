package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
 //Boyer-Moore Voting Algorithm
 // Time: O(n)  space = O(1)

    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return nums[0];
        int count = 0;
        Integer candidate = null;
        for(int num : nums){
            if(count==0){
                candidate = num;
            }
            count += (num==candidate ? 1 : -1);
        }
        return candidate;
    }

  /*

  public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int n : map.keySet()){
            if(map.get(n) > nums.length/2){
                return n;
            }
        }
        return -1;
    }

   */
}
