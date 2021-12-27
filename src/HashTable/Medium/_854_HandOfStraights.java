package HashTable.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _854_HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Arrays.sort(hand);
        int count = 0;
        for(int num : hand){
            if(!map.containsKey(num)) continue;
            count = 0;
            int val = num;
            while(map.containsKey(val) && count < groupSize){
                count++;
                map.put(val, map.getOrDefault(val, 0)-1);
                if(map.get(val)==0) map.remove(val);
                val++;
            }
            if(count != groupSize) return false;
        }
        return true;
    }
}
