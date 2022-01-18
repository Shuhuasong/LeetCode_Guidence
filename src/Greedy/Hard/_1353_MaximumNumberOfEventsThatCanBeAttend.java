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
       public int maxEvents(int[][] events) {
       //Sort events increase by start time
       Arrays.sort(events, (a, b)->a[0]-b[0]);
       //pq keeps the current open events
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       int count =0, i = 0;
       int n = events.length;
       //iterate the day from 1 to 100000
       for(int d=1; d<=100000; d++){
           //remove the events that already closed
           while(!pq.isEmpty() && pq.peek() < d){
               pq.poll();
           }
           //each day, we add new events starting on day 'd'
           while(i<n && events[i][0]==d){
               pq.offer(events[i][1]);
               i++;
           }
           //greedily attend the event that ends soonest
           //if we can attend the meeting, we increment the result
           if(!pq.isEmpty()){
               pq.poll();
               count++;
           }
       }
       return count;
    }
     */
}
