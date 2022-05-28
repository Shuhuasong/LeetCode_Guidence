package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1814_CountNicePairsInAnArray {

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int MOD = (int)1e9+7;
        int count = 0;
        for(int num : nums){
            int revNum = getReverse(num);
            int diff = num-revNum;
            count = (count + map.getOrDefault(diff, 0))%MOD;
            map.put(diff, map.getOrDefault(diff,0)+1);
        }
        return count;
    }

    private int getReverse(int num){
        int val = 0;
        while(num > 0){
            int rem = num%10;
            val = val*10 + rem;
            num /= 10;
        }
        return val;
    }
}
