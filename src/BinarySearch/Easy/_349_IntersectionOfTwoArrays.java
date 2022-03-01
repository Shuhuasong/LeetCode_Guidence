package BinarySearch.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersection(nums2, nums1);
        Arrays.sort(nums1);
        Set<Integer> ansSet = new HashSet<>();
        for(int i=0; i<nums2.length; i++){
            if(ansSet.contains(nums2[i])) continue;
            if(binarySearch(nums1, nums2[i])){
                ansSet.add(nums2[i]);
            }
        }
        int[] res = new int[ansSet.size()];
        int k = 0;
        for(int a : ansSet) res[k++] = a;
        return res;
    }

    private boolean binarySearch(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[mid] < target) l = mid + 1;
            else
                r = mid-1;
        }
        return false;
    }

    /*
    //Time = O(m+n), Space = O(max(m, n))
     public int[] intersection(int[] nums1, int[] nums2) {
         if(nums1.length > nums2.length) return intersection(nums2, nums1);
         Set<Integer> set = new HashSet<>();
         for(int num : nums1) set.add(num);
         Set<Integer> list = new HashSet<>();
         for(int num : nums2){
             if(set.contains(num)) list.add(num);
         }
         int[] res = new int[list.size()];
         int i = 0;
         for(int a : list) res[i++] = a;
         return  res;
    }
     */
}
