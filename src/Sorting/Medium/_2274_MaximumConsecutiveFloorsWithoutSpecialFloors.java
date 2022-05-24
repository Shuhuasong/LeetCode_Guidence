package Sorting.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _2274_MaximumConsecutiveFloorsWithoutSpecialFloors {

    public int maxConsecutive(int bottom, int top, int[] special) {
        int maxRes = 0, n = special.length;
        Arrays.sort(special);
        for(int i=1; i<n; i++){
            maxRes = Math.max(maxRes, special[i]-special[i-1]-1);
        }
        if(special[0] > bottom){
            maxRes = Math.max(maxRes, special[0]-bottom);
        }
        if(special[n-1]<top){
            maxRes = Math.max(maxRes, top-special[n-1]);
        }
        return maxRes;
    }
}
