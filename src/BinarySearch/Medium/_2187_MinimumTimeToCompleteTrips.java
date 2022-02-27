package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _2187_MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long res = 0l;
        int n = time.length;
        long l=1, r=(long)time[0]*totalTrips;
        while(l<=r){
            long mid = l+(r-l)/2;
            long numTrips = 0;
            for(int t : time) numTrips += mid/t;
            if(numTrips < totalTrips){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
