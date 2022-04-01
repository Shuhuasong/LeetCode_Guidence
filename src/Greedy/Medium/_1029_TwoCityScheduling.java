package Greedy.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1029_TwoCityScheduling {

    //Greedy : Time = O(n)
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b)->(a[0]-a[1])-(b[0]-b[1]));
        int total = 0, n =costs.length/2;
        for(int i=0; i<n; i++){
            total += costs[i][0] + costs[i+n][1];
        }
        return total;
    }
}
