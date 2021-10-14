package Array.Medium;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by Shuhua Song
 */
public class _1878_GetBiggestThreeRhombusSumsInaGrid {



    //Time = O(m*n * m*n)
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int R = Math.min(i, j);//get minimum radius
                R = Math.min(R, m-i-1);
                R = Math.min(R, n-j-1);
                set.add(grid[i][j]);
                for(int r=1; r<=R; r++){
                    int x = i-r, y = j; //the vertex
                    int sum = 0;
                    for(int k=0; k<r; k++){
                        x += 1;
                        y -= 1;
                        sum += grid[x][y];
                    }
                    for(int k=0; k<r; k++){
                        x += 1;
                        y += 1;
                        sum += grid[x][y];
                    }

                    for(int k=0; k<r; k++){
                        x -= 1;
                        y += 1;
                        sum += grid[x][y];
                    }

                    for(int k=0; k<r; k++){
                        x -= 1;
                        y -= 1;
                        sum += grid[x][y];
                    }
                    set.add(sum);
                }
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : set){
            q.add(s);
            if(q.size() > 3){
                q.poll();
            }
        }
        int[] res = new int[q.size()];
        int i = q.size()-1;
        while(!q.isEmpty()){
            res[i--] = q.poll();
        }
        return res;
    }

    /*
      //Time = O(m*n * Math.max(m, n))
    public int[] getBiggestThree(int[][] grid) {
         int m = grid.length, n = grid[0].length;
         int[][] preSum1 = new int[50][50];
         int[][] preSum2 = new int[50][50];
         TreeSet<Integer> set = new TreeSet<>();

         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 preSum1[i][j] = ((i-1>=0 && j-1>=0) ? preSum1[i-1][j-1] : 0) + grid[i][j];
             }
         }

        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                preSum2[i][j] = ((i-1>=0 && j+1<n) ? preSum2[i-1][j+1] : 0) + grid[i][j];
            }
        }


         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 int R = Math.min(i, j);//get minimum radius
                 R = Math.min(R, m-i-1);
                 R = Math.min(R, n-j-1);
                 set.add(grid[i][j]);
                 for(int r=1; r<=R; r++){
                    int sum = 0;
                    int x1 = -1,y1 = -1, x2 = -1, y2 = -1;

                    x1 = i-r; y1 = j; //leftTop --> rightBottom
                    x2 = i;   y2 = j+r;
                    sum += preSum1[x2][y2] - ((x1-1>=0 && y1-1>=0) ? preSum1[x1-1][y1-1] : 0);

                    x1 = i;   y1 = j-r; //leftTop --> rightBottom
                    x2 = i+r; y2 = j;
                    sum += preSum1[x2][y2] - ((x1-1>=0 && y1-1>=0) ? preSum1[x1-1][y1-1] : 0);

                    x1 = i-r; y1 = j;
                    x2 = i; y2 = j-r;
                    sum += preSum2[x2-1][y2+1] - preSum2[x1][y1];

                    x1 = i; y1 = j+r;
                    x2 = i+r; y2 = j;
                    sum += preSum2[x2-1][y2+1] - preSum2[x1][y1];
                    set.add(sum);

                 }
             }
         }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : set){
            q.add(s);
            if(q.size() > 3){
                q.poll();
            }
        }
        int[] res = new int[q.size()];
        int i = q.size()-1;
        while(!q.isEmpty()){
            res[i--] = q.poll();
        }
        return res;
    }
     */
}
