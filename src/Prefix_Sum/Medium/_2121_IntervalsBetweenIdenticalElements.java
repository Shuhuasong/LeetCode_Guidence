package Prefix_Sum.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _2121_IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        long[] res = new long[n];
        long preSum  = 0, sufSum = 0, curr = 0;
        for(List<Integer> list : map.values()){
            int size = list.size();
            List<Long> prefixSum = new ArrayList<>();
            long first = (long)list.get(0);
            prefixSum.add(first);
            for(int i=1; i<size; i++){
                prefixSum.add(prefixSum.get(i-1) + list.get(i));
            }
            for(int i=0; i<size; i++){
                preSum = (i==0) ? 0 : prefixSum.get(i-1);
                curr = list.get(i);
                sufSum = prefixSum.get(size-1) - prefixSum.get(i);
                res[list.get(i)] = curr * i -  preSum + sufSum - (size-i-1) * curr;
            }
        }
        return res;
    }
}

/*
consider 2's at different position of an array
x  y  z  p  q
2  2  2  2  2
consider 2 at index z : |z-x| + |z-y| + |z-p| + |z-q|
when we loop arr from left to right, we store sum and count of previous indices of nums in Map
Since z > x,y, so
|z-x| + |z-y| = z-x + z-y
              = 2z - (x+y)
              = count*(currVal) - sum
Similarly, we can calculate the |z-p| + |z-q| when we loop through from right to left
Or
num = currVal
the sum of left part(exclude currVal): (num-left1) + (num-left2) + (num-left3) + .... + (num-leftn)
          = i * num - preSum
the sum of right part : (totalSum-preSum)-(size-i-1)*num
          = sufixSum-(size-i-1) * num
 */
