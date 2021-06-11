package HashTable.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int rows = wall.size();
        // if(rows==0) return 0;
        // if(wall.get(0).size()==1) return rows;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int sum = 0; // sum: record the position of gap for every brick in each row
            for(int i=0; i<list.size()-1; i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int res = rows;
        for(int key : map.keySet()){
            res = Math.min(res, rows-map.get(key));
        }
        return res;
    }
}
