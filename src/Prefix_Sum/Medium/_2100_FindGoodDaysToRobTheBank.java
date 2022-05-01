package Prefix_Sum.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _2100_FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n], right = new int[n];
        for(int i=1; i<n; i++){
            //before: non-increasing==>decreasing
            if(security[i]<=security[i-1]){
                left[i] = left[i-1] + 1;
            }
            //after: non-decreasing==> increasing
            int r = n-i-1;
            if(security[r] <= security[r+1]){
                right[r] = right[r+1] + 1;
            }
        }
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(left[i]>=time && right[i]>=time) results.add(i);
        }
        return results;
    }
}


/*
Solution-PreSum:
1) each day, need the number of days which are greater than or equal with
   current day, so we can use dp to iterate: from left to right, and from
   right to left
   */