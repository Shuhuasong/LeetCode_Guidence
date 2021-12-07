package HashTable.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _939_MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points){
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int n = points.length;
        int minRes = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if(x1==x2 || y1==y2) continue;
                if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                    minRes = Math.min(minRes, Math.abs(x2-x1) * Math.abs(y2-y1));
                }
            }
        }
        return minRes == Integer.MAX_VALUE ? 0 : minRes;
    }
}

/*
Solution:
 Find two points A, B first, and then check if the other two points C, D
 are in the points
 |
 | A     C
 |
 | D     B
 |______________
 A = (x1, y1)
 B = (x2, y2)

 */
