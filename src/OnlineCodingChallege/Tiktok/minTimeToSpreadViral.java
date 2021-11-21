package OnlineCodingChallege.Tiktok;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
/*
you are given 2 m x n grids, A and B where each cell can have one of three values:
-- O represents a person without tiktok
-- T represents a tiktok user
-- V represents a user who's seen the viral trend
every minute, any tiktok user (T) that is 4-directionally adajacent to a viral video (V) gets shown the video.
Grid A is the starting grid
Grid B is the forecasting ending grid
Return the minimum numbers of minites that is takes until the video goes viral, starting at grid A until all forecasted users have seen the video, grid B
, that is the number of minutes if takes until grid A turns to grid B.
If the video isn't viral, return -1

Example 1: A = {{'V', 'T', 'T'},             B =  {{'V', 'V', 'V'},
                {'T', 'T', 'O'},    ->            {'V', 'V', 'O'},
                {'O', 'T', 'T'}};                 {'O', 'V', 'T'}};
output : 3

Example 2:
            A = {{'V', 'V', 'T'},              B =  {{'V', 'V', 'V'},
                 {'O', 'T', 'T'},       ->           {'O', 'V', 'V'},
                 {'T', 'O', 'T'}};                   {'V', 'O', 'V'}};
output : -1
Explanation: the human in the bottom left corner (row2, col0), is never shown the viral video

Example 3:
            A = { {'O', 'V'}}      ->       B =  {{'O', 'V'}};
output : 0
Since the two grid are the same, the answer is 0

Example 2:
            A = {{'V', 'V', 'T'},              B =  {{'V', 'V', 'V'},
                 {'T', 'T', 'O'},       ->           {'V', 'V', 'O'},
                 {'O', 'T', 'T'}};                   {'O', 'T', 'T'}};
output : 2

 */
public class minTimeToSpreadViral {

    private static int minTimeInfectVideos(char[][] A, char[][] B){
        int rows = A.length, cols = A[0].length;
        boolean isSame = true;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(A[i][j] != B[i][j]){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame) return 0;
        char[][] C = new char[rows][cols];
        Queue<int[]> q = new LinkedList<>();
         for(int i=0; i<rows; i++){
             for(int j=0; j<cols; j++){
                 C[i][j] = A[i][j];
                 if(A[i][j]=='V'){
                     q.add(new int[]{i, j, 0});
                 }
             }
         }
         int result = 0;
         boolean[][] visited = new boolean[rows][cols];
         int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
         while(!q.isEmpty()){
            // System.out.println(q.size());
             int[] cell = q.poll();
             int x = cell[0], y = cell[1];
             int steps = cell[2];
             visited[x][y] = true;
             result = Math.max(result, steps);
             for(int[] dir : dirs){
                 int nx = x + dir[0];
                 int ny = y + dir[1];
                 if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || B[nx][ny] != 'V' || visited[nx][ny]) continue;
                 C[nx][ny] = 'V';
                 visited[nx][ny] = true;
                 q.add(new int[]{nx, ny, steps+1});
             }
         }
         boolean isValid = false;
         for(int i=0; i<rows; i++){
             for(int j=0; j<cols; j++){
                 if(B[i][j] != C[i][j]){
                     return -1;
                 }
             }
         }
         for(int i=0; i<rows; i++){
             for(int j=0; j<cols; j++){
                 System.out.print(C[i][j] + " ");
             }
             System.out.println();
         }
         return result;
    }

    public static void main(String[] args) {
        char[][] A = {{'V', 'T', 'T'},
                      {'T', 'T', 'O'},
                      {'O', 'T', 'T'}};
        char[][] B = {{'V', 'V', 'V'},
                      {'V', 'V', 'O'},
                      {'O', 'V', 'T'}};
        System.out.println(minTimeInfectVideos(A, B));
    }
}
