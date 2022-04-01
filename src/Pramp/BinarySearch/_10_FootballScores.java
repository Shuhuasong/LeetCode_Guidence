package Pramp.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
TeamA = {1, 2, 3}
TeamB = {2, 4}
for each score in teamB, find how many points in the teamA which are
less than or equal to teamB[i]
 */
public class _10_FootballScores {
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here
        Collections.sort(teamA);
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<teamB.size(); i++){
            int idx = binarySearch(teamA, teamB.get(i));
            results.add(idx);
        }
        return results;
    }


    private static int binarySearch(List<Integer> A, int target){
        int start = 0, end = A.size()-1;
        int res = A.size();
        while(start <= end){
            int mid = start + (end-start)/2;
            int midVal = A.get(mid);
            if(midVal <= target){
                start = mid+1;
            }else{
                res = mid;
                end = mid-1;
            }
        }
        return res;
    }
}
