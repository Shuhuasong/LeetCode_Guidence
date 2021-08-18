package Backtrack.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates==null || candidates.length==0) return results;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0,  new ArrayList<Integer>(),  results);
        return results;
    }

    private void backtrack(int[] nums,  int remain, int start, ArrayList<Integer> list,  List<List<Integer>> results){
        if(remain==0){
            results.add(new ArrayList<Integer>(list));
            return;
        }else if(remain < 0){
            return;
        }

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, remain-nums[i], i, list, results);
            list.remove(list.size()-1);
        }
    }
}
