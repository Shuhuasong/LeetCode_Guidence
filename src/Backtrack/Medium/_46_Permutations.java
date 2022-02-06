package Backtrack.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _46_Permutations {

    //Time = O(N!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> results){
        if(list.size()==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list, results);
            list.remove(list.size()-1);
        }
    }

    //Time: O(P(N, k)), P(N, k) = N!/(N-k)! = N(N-1)...(N-k+1)
    //Space: O(N!)
 /*   public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums) { list.add(num); }
        int n = nums.length;
        backtrack(n, list, results, 0);
        return results;
    }

      private void backtrack(List<Integer> list, int start, List<List<Integer>> res){
        //when start == list.size, the permutaion is done for this list
        if(start == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<list.size(); i++){
            Collections.swap(list, start, i);
            //next recursion need to start from next start
            backtrack(list, start+1, res);
            Collections.swap(list, start, i);
        }
    }

  */
}

/*
Approach 1: Backtracking
Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.

Here is a backtrack function which takes the index of the first integer to consider as an argument backtrack(first).

If the first integer to consider has index n that means that the current permutation is done.
Iterate over the integers from index first to index n - 1.
Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
Now backtrack, i.e. swap(nums[first], nums[i]) back.
 */
