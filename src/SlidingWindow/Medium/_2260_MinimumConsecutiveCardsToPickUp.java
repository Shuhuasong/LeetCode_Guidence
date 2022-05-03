package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _2260_MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<cards.length; i++){
            if(map.containsKey(cards[i])){
                minLen = Math.min(minLen, i-map.get(cards[i])+1);
            }
            map.put(cards[i], i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
