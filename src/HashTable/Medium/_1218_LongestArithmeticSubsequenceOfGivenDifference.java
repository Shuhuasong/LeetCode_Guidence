package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1218_LongestArithmeticSubsequenceOfGivenDifference {
    //Dp + HashMap
    //Time = O(n)
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, prevCnt = 0;
        for(int a : arr){
            prevCnt = map.getOrDefault(a-difference, 0);
            map.put(a, prevCnt+1);
            res = Math.max(res, map.get(a));
        }
        return res;
    }
}
