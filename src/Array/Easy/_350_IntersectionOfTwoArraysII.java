package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _350_IntersectionOfTwoArraysII {

    //Time = O(m+n) Space = O(min(m, n))
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num, 0);
            if(count > 0){
                nums1[k++] = num;
                map.put(num, count-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    //Sort
    //Time: O(nlogn + mlogm)
 /*   public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, k=0;
        int m = nums1.length, n = nums2.length;
        List<Integer> list =new ArrayList<>();

        while(i<m && j<n){
            if(nums1[i]< nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] results = new int[list.size()];

        for(int a : list){
            results[k++] = a;
        }
        return results;
    }

  */

}
