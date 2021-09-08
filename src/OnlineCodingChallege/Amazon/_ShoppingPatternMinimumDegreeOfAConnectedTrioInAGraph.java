package OnlineCodingChallege.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
/*
A connected trio is a set of three nodes where there is an edge between every pair of them
The degree of a connected trio is the number of edges where one endpoint is in the trio, and
hte other is not.
Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios

Example 1:
 n = 6, edges = { {1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6} }
 output = 3
 */
public class _ShoppingPatternMinimumDegreeOfAConnectedTrioInAGraph {

    private static int minTrioDegree(int n, int[][] edges){
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> degreeMap = new HashMap<>();
        boolean[][] isEdge = new boolean[n+1][n+1];
        for(int[] edge : edges){
            degreeMap.put(edge[0], degreeMap.getOrDefault(edge[0], 0) + 1);
            degreeMap.put(edge[1], degreeMap.getOrDefault(edge[1], 0) + 1);
            isEdge[edge[0]][edge[1]] = true;
            isEdge[edge[1]][edge[0]] = true;
        }
        for(int[] edge : edges){
            for(int i=1; i<=n; i++){
                if(isEdge[i][edge[0]] && isEdge[i][edge[1]]){
                    int degree = degreeMap.get(i) + degreeMap.get(edge[0]) + degreeMap.get(edge[1]) - 6;
                    //System.out.println(degreeMap.get(i) + " " + degreeMap.get(edge[0]) + " " + degreeMap.get(edge[1]));
                    //System.out.println(min + " " + degree);
                    min = Math.min(min, degree);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
      int n1 = 6;
      int[][] edges1 = {{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
        System.out.println(minTrioDegree(6, edges1));
      int[][] edges2 = {{1, 3}, {4, 1}, {4, 3}, {2, 5}, {5, 6}, {6, 7}, {7, 5}, {2, 6}};
        System.out.println(minTrioDegree(7, edges2));
    }
}
