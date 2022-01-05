package Backtrack.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _40_CombinationSumII {
    //Time = O(2^n)
    //Space = O(n)
    //we need to skip certain positions, in order to avoid the generation of duplicated combinations
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>());
        return results;
    }

    private void backtrack(int[] nums, int start, int remain, List<Integer> currList){
        //do early stop

        if(remain==0) {
            results.add(new ArrayList<Integer>(currList));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            if(remain-nums[i] < 0) continue;
            currList.add(nums[i]);
            backtrack(nums, i+1, remain-nums[i], currList);
            currList.remove(currList.size()-1);
        }
    }
}
