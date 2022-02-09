package Array.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _253_MeetingRoomsII {

    //The same with the question "Number Of Airplane In The Sky"
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals){
            list.add(new int[]{i[0], 1}); //start meeting
            list.add(new int[]{i[1], -1}); // end meeting
        }
        Collections.sort(list, (a, b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int count = 0, res = 0;
        for(int[] l : list){
            count += l[1];
            res = Math.max(res, count);
        }
        return res;
    }

    /*
       public int minMeetingRooms(int[][] intervals) {
          if(intervals==null || intervals.length==0) return 0;
          //sort the array by start time
          Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
          PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1]-b[1]);
          minHeap.add(intervals[0]);
          for(int i=1; i<intervals.length; i++){
              int[] curr = intervals[i];
              //the previous meeting has ended before next meeting start
              if(minHeap.peek()[1] <= curr[0]){
                  minHeap.poll();
              }
              //add the meeting in queue
              minHeap.add(curr);
          }
        return minHeap.size();
    }
     */
}

/*
Intuitive:
1) we sort the array according to the start time;
2) add first meeting ino priorityQueue, this pq sort according to
   the end time, and iterate meeting one by one.
   if the next meeting's startTime > prev meeting's endTime, it
   means we can reuse the prev meeting room.
   else if next startTime < prev EndTime, we need another meeting
   room, since both of them are overlap.

[0,30],[5,10],[15,20]

*/


