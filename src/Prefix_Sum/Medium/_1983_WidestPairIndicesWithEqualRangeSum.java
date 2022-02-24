package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1983_WidestPairIndicesWithEqualRangeSum {
    //pre1[j]-pre1[i]==pre2[j]-pre2[i]==> pre1[j]-pre2[j] = pre2[i]-pre1[i]
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] preSum1 = new int[n+1], preSum2 = new int[n+1];
        for(int i=0; i<n; i++){ preSum1[i+1] = preSum1[i]+nums1[i]; }
        for(int i=0; i<n; i++){ preSum2[i+1] = preSum2[i]+nums2[i]; }
        int[] diff = new int[n+1];
        for(int i=0; i<=n; i++){
            diff[i] = preSum1[i]-preSum2[i];
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i=1; i<=n; i++){
            if(map.containsKey(diff[i])){
                res = Math.max(res, i-map.get(diff[i]));
            }else{
                map.put(diff[i], i);
            }
        }
        return res;
    }
}

/*
令pre1表示nums1的前缀和数组，pre2表示nums2的前缀和数组。本题即求跨度最大的{i,j}使得

pre1[j]-pre1[i] = pre2[j]-pre2[i]
稍微移项变换

pre1[j]-pre2[j] = pre1[i]-pre2[i]
令diff数组表示pre1-pre2之差，那么本题的本质就是在diff数组里找跨度最大的{i,j}使得

dfff[i] = diff[j]
*/
