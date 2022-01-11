package SlidingWindow.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _219_ContainsDuplicateII {

    //Time = O(n )
    //Space = O(min(n, k))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    //Time Limit Exceed
    //Time = O(n * min(k, n))
 /*   public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=Math.max(0, i-k); j<i; j++){
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }  */
}
