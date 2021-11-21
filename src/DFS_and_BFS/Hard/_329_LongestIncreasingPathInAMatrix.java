package DFS_and_BFS.Hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _329_LongestIncreasingPathInAMatrix {

    //DFS + Memoization
    // Time : = O(V+E) = O(mn), V = #cells, E = 4V = #edges
    // Space = O(m*n)
    int[][] dirs = {{0, -1}, {0, 1},{1, 0}, {-1, 0}};
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int result = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result = Math.max(result, dfs(i, j, memo));
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] memo){
        if(memo[i][j] != 0) return memo[i][j];
        int rows = memo.length, cols = memo[0].length;
        for(int[] dir : dirs){
            int nx = i+dir[0], ny = j + dir[1];
            if(nx>=0 && nx<rows && ny>=0 && ny<cols && matrix[nx][ny] > matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j], dfs(nx, ny, memo));
            }
        }
        memo[i][j]++;
        return memo[i][j];
    }
     /*
    BFS + topological sort
    1) fo find longest increasing path, we need to start from lowest number==> using InDegree to record th
       the number of element less than current element, if it is smallest, inDegree[i][j] = 0
    2) After find the smallest, do BFS for these number
    3) During the BFS process, we find the next smallest number and do BFS for these numbers by decrement the inDegree
       for all nearest numbers */


    // Time : = O(mn ), m = rows, n = cols
    // Space = O(m*n)
 /*   int[][] dirs = {{0, -1}, {0, 1},{1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] inDegree = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                for(int[] dir : dirs){
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if(nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                            matrix[i][j] > matrix[nx][ny]){
                        inDegree[i][j]++;
                    }
                }
                if(inDegree[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                            matrix[nx][ny] > matrix[x][y]){
                        inDegree[nx][ny]--;
                        if(inDegree[nx][ny]==0){
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            result++;
        }
        return result;
    } */


    /*
     //DFS ==> TLE
   // Time : = O(2^(m+n))
   // Space = O(m*n)
     int[][] dirs = {{0, -1}, {0, 1},{1, 0}, {-1, 0}};
     int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        int rows = matrix.length, cols = matrix[0].length;
        int result = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result = Math.max(result, dfs(i, j));
            }
        }
        return result;
    }

    private int dfs(int i, int j){
        int steps = 0;
        int rows = matrix.length, cols = matrix[0].length;
        for(int[] dir : dirs){
            int nx = i+dir[0], ny = j + dir[1];
            if(nx>=0 && nx<rows && ny>=0 && ny<cols && matrix[nx][ny] > matrix[i][j]){
                steps = Math.max(steps, dfs(nx, ny));
            }
        }
        steps++;
        return steps;
    }
     */
}
