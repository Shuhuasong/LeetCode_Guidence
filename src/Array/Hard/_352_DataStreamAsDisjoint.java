package Array.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Shuhua Song
 */
public class _352_DataStreamAsDisjoint {
    TreeSet<int[]> treeset = new TreeSet<>((a, b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
    public _352_DataStreamAsDisjoint() {

    }

    public void addNum(int val) {
        int[] interval = new int[]{val, val};
        if(treeset.contains(interval)) return;
        int[] low = treeset.lower(interval), high = treeset.higher(interval);
        //combine 3 component: low, interval, high
        if(high != null && high[0]==val) return;
        if(low!=null && low[1]+1 == val && high!=null && val+1==high[0]){
            low[1] = high[1];
            treeset.remove(high);
        }else if(low!=null && low[1]+1 >= val){ //combined with left side (low)
            low[1] = Math.max(low[1], val);
        }else if(high!=null && val+1==high[0]){ //combined with right side (high)
            high[0] = val;
        }else{
            treeset.add(interval);
        }
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for(int[] interval : treeset) res.add(interval);
        return res.toArray(new int[res.size()][]);
    }
}


/*

1) |_______|=====|_______|

2) |_______|===|  |______|

3) |_______|  |===|_______|


*/
