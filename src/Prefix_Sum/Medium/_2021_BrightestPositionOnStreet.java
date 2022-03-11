package Prefix_Sum.Medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _2021_BrightestPositionOnStreet {
    public int brightestPosition(int[][] lights) {
        Map<Integer,Integer> treemap = new TreeMap<>();
        for(int[] l : lights){
            int start = l[0]-l[1];
            int end = l[0] + l[1] + 1;
            //enter light range
            treemap.put(start, treemap.getOrDefault(start, 0)+1);
            //exit light range
            treemap.put(end, treemap.getOrDefault(end, 0)-1);
        }
        int currDist = 0, maxDist = 0, res = 0;
        for(int pos : treemap.keySet()){
            currDist += treemap.get(pos);
            if(maxDist < currDist){
                maxDist = currDist;
                res = pos;
            }
        }
        return res;
    }
}

/*
e.g
lights = [[-3,2],[1,2],[3,3]]
treemap: {{-5, 1}, {-1, 1}, {0, 0}, {4, -1}, {7, -1}}
currDist:   1    ,    2   ,    2  ,    1   ,   0
maxDist:    1    ,    2   ,    2  ,    2   ,   2
res :       -5   ,    -1  ,    -1 ,    -1  ,   -1
*/

