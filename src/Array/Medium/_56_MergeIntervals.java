package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _56_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

        List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];
        for(int[] next : intervals){
            //overlap
            if(curr[1] >= next[0]) curr[1] = Math.max(curr[1], next[1]);
            else{
                list.add(curr);
                curr = next;
            }
        }
        list.add(curr);
        return list.toArray(new int[list.size()][]);
    }

    /*
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

        List<int[]> list = new ArrayList<>();
        for(int[] inter : intervals){
            if(list.isEmpty()){
                list.add(inter);
            }else{
                int last = list.get(list.size()-1)[1];
                if(last < inter[0]){
                    list.add(inter);
                }else{
                    int start = list.get(list.size()-1)[0];
                    int end = Math.max(inter[1], list.get(list.size()-1)[1]);
                    list.remove(list.size()-1);
                    list.add(new int[]{start, end});
                }
            }
        }
        int size = list.size();
        int[][] results = new int[size][2];
        int i = 0;
        for(int[] item : list){
            results[i++] = item;
        }
        return results;
    } */
}


/*

[1,      3]
    [2,      6]
                 [8,10]
                        [15,18]
                        */