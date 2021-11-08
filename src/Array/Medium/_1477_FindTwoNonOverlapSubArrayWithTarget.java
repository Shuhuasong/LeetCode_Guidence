package Array.Medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _1477_FindTwoNonOverlapSubArrayWithTarget {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] preSum = new int[n+1];
        int[] minLenArr = new int[n+1];
        int minLen = Integer.MAX_VALUE;
        int res = minLen;
        preSum[0] = 0;
        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i] + arr[i];
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<=n; i++){
            map.put(preSum[i], i);
        }
        for(int i=0; i<=n; i++){
            if(map.containsKey(preSum[i]-target)){
                int preIdx = map.get(preSum[i]-target);
                minLen = Math.min(minLen, i-preIdx);
                if(minLenArr[preIdx] < Integer.MAX_VALUE){
                    res = Math.min(res, i-preIdx+minLenArr[preIdx]);
                }
            }
            minLenArr[i] = minLen;
            // System.out.println(i + " " + minLenArr[i] + " " + res);
        }
        //for(int i=0; i<=n ; i++){
        //    System.out.println(i + " " + minLenArr[i]);
        // }
        return res < Integer.MAX_VALUE ? res : -1;
    }
}

/*
1) preSum is the sum of prefix ending at i-1
2) using minLenArr[i] to keep the min Length of valid subarray ending at i-1
3) using map to remember all prefix sum index
4) compare the minLen when find a new subArray
*/

