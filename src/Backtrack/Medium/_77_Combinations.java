package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _77_Combinations {
    List<List<Integer>> results;
    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        if(n < k) return results;
        backtrack(1, n, k, new ArrayList<>());
        return results;
    }

    private void backtrack(int start, int n, int remain, List<Integer> currList) {
        if(remain==0) {
            results.add(new ArrayList<Integer>(currList));
            return;
        }
        for(int i=start; i<=n; i++) {
            currList.add(i);
            backtrack(i+1, n, remain-1, currList);
            currList.remove(currList.size()-1);
        }
    }
}
