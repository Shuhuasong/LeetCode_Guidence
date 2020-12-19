package Array.Medium;

import java.util.*;

public class _15_3Sum {
    //Two Pointer ( Array NEED To Be SORTED!!!)
    //Idea: used the for loop to fix the first number, then used left pointer to fix
    //      the second number, and use right pointer to find the appropriate third number
    //      use set to check the duplicate element
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = 0;
        for(int i=0; i<n-2; i++){
            l = i + 1; r = n-1;
            while(l < r){
                if(nums[l] + nums[r] < -nums[i]){
                    l++;
                }else if(nums[l] + nums[r] > -nums[i]){
                    r--;
                }else{
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[l]);
                    curList.add(nums[r]);
                    if(!set.contains(curList)){
                        set.add(curList);
                    }
                    l++;
                    r--;
                }
            }
        }
        for(List<Integer> list : set){
            result.add(list);
        }
        return result;
    }

    /*
      //Two Pointer: Time = O(n^2)  space:   //Two Pointer: Time = O(n^2)  space: O(logn) - O(n) depending on the implementation of the sorting algorithm.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
           if(i==0 || nums[i-1]!=nums[i]){ //skip the duplicate element
               twoSumII(nums, i, results);
           }
        }
        return results;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> results){
            int  l = i + 1, r = nums.length-1;
            while(l < r){
                if(nums[l] + nums[r] < -nums[i]){
                    l++;
                }else if(nums[l] + nums[r] > -nums[i]){
                    r--;
                }else{
                    List<Integer> curList = new ArrayList<>();
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
          }
     }
     */

    //HashMap: Time = O(n^2)  space = O(n)
/*  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n && nums[i]<=0; i++){ //find first element this is negative fisrt
            if(i==0 || nums[i-1]!=nums[i]){ //skip the duplicate element
                twoSumII(nums, i, results);
            }
        }
        return results;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> results){
        HashSet<Integer> seem = new HashSet<>();
        for(int j=i+1; j<nums.length; j++){
            int comp = -(nums[i]+nums[j]);
            if(seem.contains(comp)){
                results.add(Arrays.asList(nums[i], nums[j], comp));
                while(j+1<nums.length && nums[j]==nums[j+1]){ //skip the duplicate element
                    j++;
                }
            }
            seem.add(nums[j]); //add the second number nums[j], not the comp
        }
    }

   */
}
