package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1272_RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        for(int[] curr : intervals){
            //no overlapping
            if(curr[1] < toBeRemoved[0] || curr[0] > toBeRemoved[1]){
                results.add(Arrays.asList(curr[0], curr[1]));
            }else{//curr[1] > toBeRemove[0] && curr[0] <= toBeRemove[1]
                //2)
                if(curr[0] < toBeRemoved[0]){
                    results.add(Arrays.asList(curr[0], toBeRemoved[0]));
                }
                //3)
                if(curr[1] > toBeRemoved[1]){
                    results.add(Arrays.asList(toBeRemoved[1], curr[1]));
                }
            }
        }
        return results;
    }
}

/*
1) ====                      ==========  add intervals into output
             --------| a |

2) ==============
   | a |__________   add interval a into output

3) ================== curr      add interval a into output
      -----------| a | toBeRemoved

      */


