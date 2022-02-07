package Backtrack.Medium;

import java.sql.Time;
import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _47_PermutationII {

     /*
     Note:
    1) check if the current elem is the same with previous one, and the previous
          elem is not visited, then we will skip the elem
    2) To make sure only use one first elem of the same group numbers

    The difficulty is to handle the duplicates, with inputs : {1a, 1b, 2a}
    If we don't handle the duplicates, the results would be : {1a, 1b, 2a}, {1b, 1a, 2a}
    So we need to make sure 1a goes before 1b to avoid duplicates by using
       nums[i-1] == nums[i] && !used[i-1], this make sure that 1b cannot be chosen before 1a

    Time = O(N*N!)
    It takes N steps to generate a single permutation. Since there are in toal N! possible permutations,
    at most it would take N*N! steps to generate all permutations
    */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), new boolean[nums.length], results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> list, boolean[] used, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        //when a number has the same value with its previous, we can use this number only
        //if this previous is used
        for(int i=0; i<nums.length; i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, i+1, list, used, res);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

   /*
    note:Algorithm
    Given the above insight, in order to find out all the unique numbers at each stage, we can build
    a hash table (denoted as counter), with each unique number as the key and its occurrence as
    the corresponding value. */

 /*   List<List<Integer>> results;
    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) freq.put(num, freq.getOrDefault(num,0)+1);
        backtrack(nums.length, freq, new ArrayList<>());
        return results;
    }

    private void backtrack(int n, Map<Integer, Integer> map, List<Integer> list) {
        if(list.size() == n) {
            results.add(new ArrayList<>(list));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count==0) continue;
            list.add(num);
            map.put(num, count-1);
            backtrack(n, map, list);
            list.remove(list.size()-1);
            map.put(num, count);
        }
    }

  */

}

