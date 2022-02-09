package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _57_InsertInterval {
    /*
  1) the newInterval is on the right side of curr==> add curr into list
  2) the newInterval is on the left side of curr==> add newInterval and curr, set = newInterval==null
  3) there is overlap between newInterval and curr ==> merge them and store it in newInterval */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] curr : intervals){
            if(newInterval==null || curr[1] < newInterval[0]){
                //curr is on the left side
                list.add(curr);
            }else if(curr[0] > newInterval[1]){
                //curr is on the right side
                list.add(newInterval);
                list.add(curr);
                newInterval=null;
            }else{
                //overlap==>merge
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        //when newInterval hasn't been added
        if(newInterval!=null) list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}

/*
1____3       6____9
   2_____5(merge)

 */

