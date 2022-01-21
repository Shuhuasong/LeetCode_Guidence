package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1570_DotProductOfTwoSparseVectors {

    /*
    Because the vector is sparse, use a data structure that stores the
    index and value where the element is nonzero.
     */

    class SparseVector{
        Map<Integer, Integer> map;
    }

    Map<Integer, Integer> map;
    _1570_DotProductOfTwoSparseVectors(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        Map<Integer, Integer> map1 = this.map;
        Map<Integer, Integer> map2 = vec.map;
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                res += map1.get(key) * map2.get(key);
            }
        }
        return res;
    }

    // Your SparseVector object will be instantiated and called as such:
    // SparseVector v1 = new SparseVector(nums1);
    // SparseVector v2 = new SparseVector(nums2);
    // int ans = v1.dotProduct(v2);

    /*
     //Non-efficient Array Approach
     private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
         int res = 0, n = vec.nums.length;
         if(this.nums.length != n) return 0;
         for(int i=0; i<n; i++){
             res += this.nums[i] * vec.nums[i];
         }
        return res;
    }
     */
}
