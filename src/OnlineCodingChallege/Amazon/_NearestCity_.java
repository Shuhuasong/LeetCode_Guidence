package OnlineCodingChallege.Amazon;

import java.util.*;

/**
 * Created by Shuhua Song
 */
/*
Anyone can provide the solution, java plz:

Given a list of points, find the nearest points that shares either an x or a y coordinate with the queried point.

The distance is denoted on a Euclidean plane: the difference in x plus the difference in y.

Input

numOfPoints, an integer representing the number of points;

points, a list of strings representing the names of each point [i];

xCoordinates, a list of integers representing the X coordinates of each point[i];

yCoordinates, a list of integers representing the Y coordinates of each point[i];

numOfQueriedPoints, an integer representing the number of points queried;

queriedPoints, a list of strings representing the names of the queried points.

Output

Return a list of strings representing the name of the nearest points that shares either an x or a y coordinate with the queried point.

Example 1:

Input:

numOfPoints = 3

points = ["p1","p2","p3"]

xCoordinates = [30, 20, 10]

yCoordinates = [30, 20, 30]

numOfQueriedPoints = 3

queriedPoints = ["p3", "p2", "p1"]

Output:

["p1", NONE, "p3"]

Example 2:

Input:

numOfPoints = 5

points = ["p1", "p2","p3", "p4", "p5"]

xCoordinates = [10, 20, 30, 40, 50]

yCoordinates = [10, 20, 30, 40, 50]

numOfQueriedPoints = 5

queriedPoints = ["p1", "p2", "p3", "p4", "p5"]

Output

[NONE, NONE, NONE, NONE, NONE]
 */
public class _NearestCity_ {

    private static String[] findNearestCity(String[] points, int[] xCoord, int[] yCoord, String[] queries, int n){
        Map<Integer, List<String>> x2PointMap = new HashMap<>();
        Map<Integer, List<String>> y2PointMap = new HashMap<>();
        HashMap<String, Integer> point2Idx = new HashMap<>();

        //Initial Map
        for(int i=0; i<n; i++){
            x2PointMap.put(xCoord[i], new ArrayList<String>());
            y2PointMap.put(yCoord[i], new ArrayList<String>());
        }
        for(int i=0; i<points.length; i++){
            x2PointMap.get(xCoord[i]).add(points[i]);
            y2PointMap.get(yCoord[i]).add(points[i]);
            point2Idx.put(points[i], i);
        }

        String[] results = new String[queries.length];
        for(int i=0; i<queries.length; i++){
            String currQuery = queries[i];
            int curIdx = point2Idx.get(currQuery);
            List<String> xNeibors = x2PointMap.get(xCoord[curIdx]);
            List<String> yNeibors = y2PointMap.get(yCoord[curIdx]);
            if(xNeibors.size()==1 && yNeibors.size()==1) continue;
            int minDist = Integer.MAX_VALUE;
            String closeCity = "";
            //get min neigbor from x coordinate and update minRes
            for(String neibCity : xNeibors) {
                if (neibCity.equals(currQuery)) continue;
                int dist = getDist(point2Idx, xCoord, yCoord, currQuery, neibCity);
                if (dist < minDist) {
                    minDist = dist;
                    closeCity  = neibCity;
                }
            }
            //get min neigbor from y coordinate and update minRes
            for(String neibCity : yNeibors){
                if(neibCity.equals(currQuery)) continue;
                int dist = getDist(point2Idx, xCoord, yCoord, currQuery, neibCity);
                if(dist < minDist){
                    minDist = dist;
                    closeCity  = neibCity;
                }
            }
            results[i] = closeCity;
        }
         return results;
    }
    private static int getDist(HashMap<String, Integer> point2Idx, int[] xCoord, int[] yCoord, String currQuery, String neibCity){
        int currIdx = point2Idx.get(currQuery);
        int neibIdx = point2Idx.get(neibCity);
        return Math.abs(xCoord[currIdx]-xCoord[neibIdx]) + Math.abs(yCoord[currIdx]-yCoord[neibIdx]);
    }

    public static void main(String[] args) {
        int numOfPoints = 3;
        String[] points1 = {"P1", "P2", "P3"};
        int[] xCoordinate1 = {30, 20, 10};
        int[] yCoordinate1 = {30, 20, 30};
        int numOfQueriedPoints = 3;
        String[] queriesPoints1 = {"P3", "P2", "P1"};
        String[] results1 = findNearestCity(points1, xCoordinate1, yCoordinate1, queriesPoints1,3);
        System.out.println(Arrays.toString(results1));

        String[] points2 = {"p1", "p2","p3", "p4", "p5"};
        int[] xCoordinate2 = {10, 20, 30, 40, 50};
        int[] yCoordinate2 = {10, 20, 30, 40, 50};
        String[] queriesPoints2 = {"p1", "p2", "p3", "p4", "p5"};
        String[] results2 = findNearestCity(points2, xCoordinate2, yCoordinate2, queriesPoints2,5);
        System.out.println(Arrays.toString(results2));
    }
}
