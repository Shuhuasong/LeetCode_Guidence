package Backtrack.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null || nums.length==0) return results;
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results){
        if(start==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        if(list.isEmpty() || list.get(list.size()-1) != nums[start]){
            //left child(not adding the curr element)
            dfs(nums, start+1, list, results);
        }
        list.add(nums[start]);
        dfs(nums, start+1, list, results);
        list.remove(list.size()-1);
    }

    /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null || nums.length==0) return results;
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results){
        if(start>nums.length) return;
        if(!results.contains(list)){
            results.add(new ArrayList<>(list));
        }
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }
     */
}
