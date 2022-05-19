package DFS_and_BFS.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _216_CombinationSum_III {
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum3(int k, int n) {
        results = new ArrayList<>();
        if(k==0 || n==0) return results;
        backtrack(k, n, 0, 1, new ArrayList<>());
        return results;
    }

    private void backtrack(int k, int n, int sum, int start, List<Integer> list){
        if(k==0 && sum==n){
            results.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=9; i++){
            if(sum+i>n) continue;
            sum += i;
            list.add(i);
            backtrack(k-1, n, sum, i+1, list);
            sum -= i;
            list.remove(list.size()-1);
        }
    }
}
