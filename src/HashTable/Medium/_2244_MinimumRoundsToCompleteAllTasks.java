package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _2244_MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int t : tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        int count = 0;
        for(int val : map.values()){
            if(val==1) return -1;
            count += val/3;
            if(val%3 != 0){
                count++;
            }
        }
        return count;
    }
}
