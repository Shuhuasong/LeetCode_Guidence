package String.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _244_ShortestWordDistanceII {
    //Time = O(n) Space = O(n)
    Map<String, List<Integer>> map; //for storing the words' indices
    public _244_ShortestWordDistanceII(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            String w = wordsDict[i];
            if(!map.containsKey(w)){
                map.put(w, new ArrayList<Integer>());
            }
            map.get(w).add(i);
        }
    }
    //use two pointer to find the minimum distance of two words
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int dist = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while(p1 < list1.size() && p2 < list2.size()){
            dist = Math.min(dist, Math.abs(list1.get(p1)-list2.get(p2)));
            if(list1.get(p1) < list2.get(p2)){
                p1++;
            }else{
                p2++;
            }
        }
        return dist;
    }
}
