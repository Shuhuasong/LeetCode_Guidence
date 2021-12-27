package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _447_NumberOfBoomerangs {
    //Time = O(n^2)
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;
        for(int i=0; i<n; i++){
            Map<Integer, Integer> distMap = new HashMap<>();
            for(int j=0; j<n; j++){
                if(i!=j){
                    int dist = getDist(points[i], points[j]);
                    distMap.put(dist, distMap.getOrDefault(dist, 0)+1);
                }
            }
            for(int val : distMap.values()){
                res += val * (val-1);
            }
        }
        return res;
    }

    private int getDist(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
