package Backtrack.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {
    //Each recursion level focus on all the following elements. We scan through all the fllowing elements and
    //decide whether or not choose that element(every level split into n branches)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        //since there are duplicate number in nums, so we need to sort the array first.
        //then to skip the same number when go into the for loop in dfs
        Arrays.sort(nums);
        if(nums==null || nums.length==0) return results;
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> list, List<List<Integer>> results){
        results.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){ continue; }
            list.add(nums[i]);
            dfs(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }

    /*
     //Each recursion level focus on one element, we need to decide choose or not choose this element(every level spit into 2 branches)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null || nums.length==0) return results;
        dfs(nums, 0, new ArrayList<>(), results, false);
        return results;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> list, List<List<Integer>> results, boolean choosePre){
        if(start==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, start+1, list, results, false);
        if(start>=1 && nums[start]==nums[start-1] && !choosePre) return;
        list.add(nums[start]);
        dfs(nums, start+1, list, results, true);
        list.remove(list.size()-1);
    }
     */
}
