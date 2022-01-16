package Greedy.Hard;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _1353_MaximumNumberOfEventsThatCanBeAttend {

    //Time = O(n*logn)
    public int maxEvents(int[][] events) {
        int n = events.length, res = 0;
        Arrays.sort(events, (a, b)->a[1]-b[1]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxDay = events[n-1][1];
        for(int i=1; i<=maxDay; i++) treeMap.put(i, 0);
        for(int[] e : events){
            int start = e[0], end = e[1];
            //the first open day for the current event
            Integer firstOpenDay = treeMap.ceilingKey(start);
            System.out.println(firstOpenDay + " " + start + " " + end);
            //The first Open day greater than start is not exist
            //If the first open day time is greater than the dealline, than it is not possible to attend
            if(firstOpenDay==null || firstOpenDay > end) continue;
            //attend the event with earliest deadline
            res++;
            treeMap.remove(firstOpenDay);
        }
        return res;
    }

    /*
    //Time = O(d + nlogn)
     public int maxEvents(int[][] A) {
       int n = A.length;
       if(n==0) return 0;
       int res = 0;
       Arrays.sort(A, (a, b)->Integer.compare(a[0], b[0]));
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       int i = 0;
       for(int d=1; d<=100000; d++){
           while(!pq.isEmpty() && pq.peek() < d){
               pq.poll();
           }
           while(i < n && A[i][0]==d){
               pq.offer(A[i][1]);
               i++;
           }
           if(!pq.isEmpty()){
               pq.poll();
               res++;
           }
       }
        return res;
    }
     */
}
