package OnlineCodingChallege.Amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
/*
Demolition Robot
Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
The demolition robot cannot enter 0 trenches and cannot leave the matrix.
Sample Input :
[1, 0, 0],
[1, 0, 0],
[1, 9, 1]]
Sample Output :
3
This question can be solved by using BFS or DFS.
 */
public class _DemolitionRobot_ {
    private static int findMinDist(int[][] matrix){
        if(matrix==null || matrix.length==0) return 0;
        if(matrix[0][0] != 1) return -1;
        int rows = matrix.length, cols = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        q.add(new int[]{0, 0, 0});
        int res = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];
            //visited.add(x*rows+y);
            if(matrix[x][y] == 9) return steps;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || matrix[nx][ny]==0 || visited.contains(nx*rows+ny)){
                    continue;
                }
                q.add(new int[]{nx, ny, steps+1});
                visited.add(nx*rows+ny);
                System.out.println(matrix[nx][ny] + " " + nx + " " + ny);
            }
            //System.out.println("res = " + res);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][]  matrix1 = { {1, 0, 0}, {1, 0, 0}, {1, 9, 1}};
        System.out.println(findMinDist(matrix1));

        int[][]  matrix2 = {
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,9,0},
                {0,0,0,0,0},
        };
       // System.out.println(findMinDist(matrix2));
    }
}
