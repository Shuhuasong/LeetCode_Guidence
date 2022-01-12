package TwoPointer.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _26_RemoveDuplicatesFromSortedArray {

    //Time = O(n), Space = O(1)
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int l = 0;
        for(int r=0; r<nums.length; r++){
            if(r==0) continue;
            if(nums[l]==nums[r]) continue;
            if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
            }
        }
        return l+1;
    }

    /*
    //Time = O(n), Space = O(n)
    public int removeDuplicates(int[] nums) {
         Set<Integer> set = new HashSet<>();
         int l = 0;
         for(int r=0; r<nums.length; r++){
             if(!set.contains(nums[r])){
                 nums[l] = nums[r];
                 l++;
                 set.add(nums[r]);
             }
         }
        return l;
    }
     */
}


/*
Note:
Since we need to keep the stable order, we need to do the in-place replacing, and
we can use the slow and faster pointer.

when move the faster pointer forward, we need to copy the element on the
position of left pointer when the element is not exist. If the element is
already exist, we just continue.

The condition to check if the element is repeated, we use
nums[right]==nums[left] (or nums[right]==nums[right-1], depend on what is the begining position of the left and right)

Finally, the position at left+1 is the output, all the element are between [0, left]

*/
