package Backtrack.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _47_PermutationII {
   /*
    note:Algorithm
    Given the above insight, in order to find out all the unique numbers at each stage, we can build
    a hash table (denoted as counter), with each unique number as the key and its occurrence as
    the corresponding value. */

    List<List<Integer>> results;
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

}

