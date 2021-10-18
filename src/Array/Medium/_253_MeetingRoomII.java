package Array.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _253_MeetingRoomII {
    //Time = O(nlogn)
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.add(intervals[0]);
        int count = 1;
        for(int i=1 ;i<n; i++){
            int[] iter = intervals[i];
            if(iter[0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.add(iter);
        }
        return pq.size();
    }
}

/*
Algorithm

Sort the given meetings by their start time.
Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
If not, then we allocate a new room and add it to the heap.
After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */
