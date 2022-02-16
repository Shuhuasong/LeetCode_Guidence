package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _370_RangeAddition {
    //Time = O(k + N), k = length of updates, n = length
    //Space = O(1)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates){
            int start = update[0], end = update[1];
            int val = update[2];
            //Mark an adding value at start point
            res[start] += val;
            //Mark and decreacing value at end+1 point
            if(end+1 < length) res[end+1] -= val;
        }
        for(int i=1; i<length; i++){
            res[i] += res[i-1];
        }
        return res;
    }

    /* Brute force--TLE
    //Time = O(k * N), k = length of updates, n = length
     public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] up : updates){
            for(int s=up[0]; s<=Math.min(length, up[1]); s++){
                res[s] += up[2];
            }
        }
        return res;
    }
     */
}
