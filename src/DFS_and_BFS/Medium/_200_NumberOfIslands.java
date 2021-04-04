package DFS_and_BFS.Medium;

public class _200_NumberOfIslands {

    //Time = O(m * n) Space = O(m * n)   m = rows n = cols
    //DFS is not recommended for this question, it will cause Stack Over Flow when the tree is very deep.(eg, when all the number are '1')
    /*
    DFS 用的是stack 上的memory， 如果题目给的case 里有全部都是1 的matrix， 这时用DFS 时深度太深，就会Stack Over Flow； 如果用BFS，用Queue 来做，
    Queue<Integer> neighbors = new LinkedList<>(); 用的是heap 上的memory, 不管数据多大， 都不会有Stack Over flow the 问题。
     */
    int ROWS, COLS;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        if(grid[0]==null || grid[0].length==0) return 0;
        ROWS = grid.length; COLS = grid[0].length;
        int result = 0;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    public int dfs(int i, int j, char[][] grid){
        if(i<0 || i>= ROWS || j<0 || j>= COLS || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0'; //marsk every visited node as '0' to mark as visited node
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        return 1;
    }
}

/*
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    //Time = O(m * n) Space = O(min(m, n)) the spce is depend on the width of the tree
    int ROWS, COLS;
    public int numIslands(char[][] grid) {
         if(grid==null || grid.length==0) return 0;
         if(grid[0]==null || grid[0].length==0) return 0;
         ROWS = grid.length; COLS = grid[0].length;
         int result = 0;
         for(int i=0; i<ROWS; i++){
             for(int j=0; j<COLS; j++){
                 if(grid[i][j]=='1'){
                     result++;
                     bfs(i, j, grid);
                 }
             }
         }
        return result;
    }
    //Put it into a queue and set its value as '0' to mark as visited node.
    public void bfs(int i, int j, char[][] grid){
        Queue<Point> queue = new LinkedList<>();
        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};
        queue.add(new Point(i, j));
        grid[i][j] = '0';
        while(!queue.isEmpty()){
            Point p = queue.remove();
            for(int k=0; k<4; k++){
                Point newPoint = new Point(p.x+rows[k], p.y+cols[k]);
                if(!inBound(newPoint)) continue;
                if(grid[newPoint.x][newPoint.y]=='1'){
                    queue.offer(newPoint);
                    grid[newPoint.x][newPoint.y] = '0';
                }
            }
        }
    }

    public boolean inBound(Point p){
        if(p.x < 0 || p.x >= ROWS || p.y < 0 || p.y >= COLS){
            return false;
        }
        return true;
    }
}
 */
