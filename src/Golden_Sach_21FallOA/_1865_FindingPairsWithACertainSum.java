package Golden_Sach_21FallOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1865_FindingPairsWithACertainSum {

    Map<Integer, Integer> map;
    int[] nums1, nums2;
    public _1865_FindingPairsWithACertainSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for(int b : nums2){
            map.put(b, map.getOrDefault(b, 0)+1);
        }
    }

    public void add(int index, int val) {
        int num = nums2[index];
        map.put(num, map.getOrDefault(num, 0)-1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0)+1);
    }

    public int count(int tot) {
        int res = 0;
        for(int num : nums1){
            int comp = tot-num;
            res += map.getOrDefault(comp, 0);
        }
        return res;
    }
}
