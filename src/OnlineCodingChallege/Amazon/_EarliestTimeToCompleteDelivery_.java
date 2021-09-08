package InterviewChallege.Amazon2020;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */

/*
Amazon Fresh Deliveries
Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
If the there is tie then choose the co-ordinate with least x value.
Sample Input :
allLocations : [ [1, 2] , [1, -1], [3, 4] ]
numOfDeliveries : 2
Sample Output :
[ [1, -1], [1 , 2] ]
Output list can be in any order.
This question was basically K closest points to the origin (0,0) with added tie condition.
 */
class _EarliestTimeToCompleteDelivery {

  /*  private static int[][]  cloestLocation(int[][] locations, int k){
         Arrays.sort(locations, (a, b)->{
             int aDist = a[0]*a[0] + a[1]*a[1];
             int bDist = b[0]*b[0] + b[1]*b[1];
             if(aDist != bDist){
                 return aDist-bDist;
             }else{
                 return a[0]-b[0];
             }
         });
         return Arrays.copyOfRange(locations, 0, k);
    } */

    private static int[][]  cloestLocation(int[][] locations, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            int aDist = a[0]*a[0] + a[1]*a[1];
            int bDist = b[0]*b[0] + b[1]*b[1];
            if(aDist != bDist){
                return bDist- aDist;
            }else{
                return b[0]-a[0];
            }
        });
        for(int[] l : locations){
            pq.add(l);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(new int[pq.size()][2]);
    }

    public static void main(String[] args) {
        int[][] locations = { {2,1}, {1, 2}, {1, -1}, {3, 4}};
        int numOfDeliveries = 2;
        int[][] results = cloestLocation(locations, 2);
        for(int[] r : results){
            for(int a : r){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
