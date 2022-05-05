package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1679_MaxNumberOf_K_SumPairs {

    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            int comp = k-nums[i];
            if(map.containsKey(comp)){
                map.put(comp, map.get(comp)-1);
                if(map.get(comp)==0) map.remove(comp);
                count++;
            }else{
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        return count;
    }
}
