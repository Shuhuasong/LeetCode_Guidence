package Backtrack.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _465_OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        // //map: record the debt
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] t :  transactions){
            map.put(t[0], map.getOrDefault(t[0], 0)+t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0)-t[2]);
        }
        List<Integer> list = new ArrayList<>();
        for(int val : map.values()){
            list.add(val);
        }
        return backtrack(0, list);
    }
   //to settle up the debt from list.get(k) -> list.get(size-1)
    private int backtrack(int start, List<Integer> list){
        if(start==list.size()) return 0;
        int curr = list.get(start);
        if(curr==0){
            return backtrack(start+1, list);
        }
        int minNum = Integer.MAX_VALUE;
        for(int i=start+1; i<list.size(); i++){
            int next = list.get(i);
            if(curr * next < 0){
                list.set(i, curr+next);
                minNum = Math.min(minNum, 1+backtrack(start+1, list));
                list.set(i, next);
            }
            if(curr+next==0) break;
        }
        return minNum;
    }
}

/*
          4
  2       | 1
0--->1--->2---->3
       4     2

0  be paid 2 (+2)
1  be paid 3 (+2)
2  pay     3 (-3)
3  pay     2 (-2)
4  be paid 1 (+1)
*/
