package DynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _871_MinimumNumberOfRefuelingStops {
    //DP -- Time = O(n^2) Space = O(n)
    /*
    dp[i] : define the fartest location we can get after i refueling stops.
    1) intial value: dp[0] = startFuel (the fartest length we can reach after 0 stops refuel)
    2) transition Function: dp[j] = Math.max(dp[j], dp[j-1]+stations[i][1])
    */
 /*   public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n+1];
        dp[0] = startFuel;
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                if(dp[j] >= stations[i][0]){
                    dp[j+1] = Math.max(dp[j+1], dp[j]+stations[i][1]);
                    System.out.println(dp[j] + " " + stations[i][1]);
                }
            }
        }
        for(int i=0; i<=n; i++){
            if(dp[i] >= target) return i;
        }
        return -1;
    } */

    //Heap -- Time = O(nlogn) space = (n), the space used by pq
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Arrays.sort(stations, (a, b)->Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)->Integer.compare(n2, n1));
        int stops = 0;
        for(int[] stat : stations){
            int dist = stat[0], gasAdd = stat[1];
            while(startFuel < dist && !pq.isEmpty()){
                startFuel += pq.poll(); // filling the gas when the startFuel less than current dist
                stops++;
            }
            if(startFuel < dist) return -1;
            pq.add(gasAdd);
        }
        while(startFuel < target && !pq.isEmpty()){
            startFuel += pq.poll();
            stops++;
        }
        return startFuel >= target ? stops : -1;
    }
}
