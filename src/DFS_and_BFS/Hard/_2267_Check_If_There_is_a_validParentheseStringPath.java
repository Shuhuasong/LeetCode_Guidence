package DFS_and_BFS.Hard;

/**
 * Created by Shuhua Song
 */
public class _2267_Check_If_There_is_a_validParentheseStringPath {
    int rows, cols;
    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        //for each cell, it has (rows+cols) status
        int[][][] memo = new int[rows][cols][rows+cols];
        return dfs(grid, 0, 0, 0, memo);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal, int[][][] memo){
        //base case
        if(r>=rows || c>=cols) return false;

        if(grid[r][c]=='('){
            bal++;
        }else{
            bal--;
        }
        //if balance < 0, it is for sure it will not match in this path
        //exist early
        if(bal < 0) return false;
        //reach the last cell
        if(r==rows-1 && c==cols-1) return bal==0;
        //if the result exist, return directly
        if(memo[r][c][bal] != 0) return memo[r][c][bal] > 0;
        //otherwise, need to explore the result. get the result from right and bottom
        boolean res = dfs(grid, r+1, c, bal, memo) || dfs(grid, r, c+1, bal, memo);
        memo[r][c][bal] = (res==true) ? 1 : -1;
        return res;
    }
}

/*
DFS : the tree depth is m+n+1
the total time complexity without memo is : 1 + 2 + 2^3 + ... + 2^(m+1)
each tree level, with 2^heights nodes, but the total value at that level is [0, height]
Therefore, there are lost of paths which do not need to calculate again when it is not valid
*/

