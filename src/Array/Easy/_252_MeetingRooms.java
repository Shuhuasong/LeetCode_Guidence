package Array.Easy;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}
