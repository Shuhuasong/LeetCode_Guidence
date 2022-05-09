package DFS_and_BFS.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _675_CutOffTreesForGolfEvent {

    public int cutOffTree(List<List<Integer>> forest) {
        int rows = forest.size(), cols = forest.get(0).size();
        int[][] grid = new int[rows][cols];
        for(int i=0; i<rows; i++){
            List<Integer> list = forest.get(i);
            for(int j=0; j<cols; j++){
                grid[i][j] = list.get(j);
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        List<int[]> tuples = getAllTuples(grid);
        Collections.sort(tuples, (a, b)->a[2]-b[2]);
        int startX = 0, startY = 0;
        int totalSteps = 0;
        while(!tuples.isEmpty()){
            int[] nextCell = tuples.get(0);
            tuples.remove(0);
            int targetX = nextCell[0], targetY = nextCell[1];
            int steps = shortestPath(grid, startX, startY, targetX, targetY);
            if(steps==-1) return -1;
            //cut the tree
            grid[targetX][targetY] = 1;
            totalSteps += steps;
            startX = targetX;
            startY = targetY;
        }
        return totalSteps;
    }

    private int shortestPath(int[][] grid, int sr, int sc, int tr, int tc){
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[][] dirs = {{0, 1},{0, -1},{1, 0}, {-1,0}};
        int steps = 0;
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                if(x==tr && y==tc) return steps;
                for(int[] dir : dirs){
                    int nx = x + dir[0], ny = y + dir[1];
                    if(nx<0 || nx>=rows || ny<0 || ny>=cols || grid[nx][ny]==0 || visited[nx][ny]) continue;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    private List<int[]> getAllTuples(int[][] grid){
        int rows = grid.length, cols = grid[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                //becareful only collection the tree whose height is greater than 1
                //height = 1 has been cut off
                if(grid[i][j] <= 1) continue;
                list.add(new int[]{i, j, grid[i][j]});
            }
        }
        return list;
    }
}

/*
Solution-BFS
        case-1:
        [4,2,3]
        [0,0,1]
        [7,6,5]
        case-2:
        [2,3,4] (0, 0)--->(2,0)--->(0,0)-->(0,1)-->....
        [0,0,5]
        [1,7,6] output = 17
        Algorithm:
        1) Sort the three by heights
        Path : (0, 0), (x1, y1), (x2, y2), ....(Xn, Yn)
        2) Find shortest path between each segment using BFS
        BFS(startX, startY, targetX, targetY) ==> O(mn)
        Time complexity: O(mn*mn), each cell has mn possible find next tree
        Space : O(mn)
*/