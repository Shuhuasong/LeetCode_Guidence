package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _849_MaximumDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, maxDist = 0;
        int n = seats.length;
        for(int i=0; i<n; i++){
            if(seats[i]==0) continue;
            //check for the fron distance
            if(prev < 0 && i!=0){
                maxDist = Math.max(maxDist, i-0);
            }else{
                maxDist = Math.max(maxDist, (i-prev)/2);
            }
            prev = i;
        }
        //check for the back distance
        if(prev != n-1 && seats[n-1]==0){
            maxDist = Math.max(maxDist, (n-1-prev));
        }
        return maxDist;
    }
}
