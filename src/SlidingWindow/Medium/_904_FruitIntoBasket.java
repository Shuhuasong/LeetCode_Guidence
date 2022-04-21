package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _904_FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, n = fruits.length;
        int l = 0;
        for(int r=0; r<n; r++){
            int curr = fruits[r];
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while(map.size()>2){
                int left = fruits[l];
                map.put(left, map.get(left)-1);
                l++;
                if(map.get(left)==0) map.remove(left);
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
