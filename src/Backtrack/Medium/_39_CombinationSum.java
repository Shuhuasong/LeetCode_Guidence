package Backtrack.Medium;

import java.util.*;

public class _39_CombinationSum {
    //Time Complexity = O(2^n)
    //Time Complexity: linear to the number of nodes of execution of backtracking tree
    //Time = O(n^(T/M)), n = nums.length, T = target, M = minimal val
    //Time = O(n^(T/M))
    Set<List<Integer>> listSet;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        listSet = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), target);
        List<List<Integer>> results = new ArrayList<>();
        for(List<Integer> list : listSet){
            results.add(list);
        }
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> currList, int remain){
        if(remain==0 && listSet.add(new ArrayList<>(currList))){
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(remain-nums[i] < 0) break;
            currList.add(nums[i]);
            backtrack(nums, i, currList, remain-nums[i]);
            currList.remove(currList.size()-1);
        }
    }
}
