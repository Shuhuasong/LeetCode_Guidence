package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    //Time = O(n * 2^n)  Space = O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results){

        if(start > nums.length) return;
        if(!results.contains(list)){
            results.add(new ArrayList<>(list));
        }
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }

    /*
     //Time = O(n * 2^n)  Space = O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results){

        if(start > nums.length) return;
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
