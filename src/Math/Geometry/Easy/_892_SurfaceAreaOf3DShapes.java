package Math.Geometry.Easy;

/**
 * Created by Shuhua Song
 */
public class _892_SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int res = 0, n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0) res += 4 * grid[i][j] + 2;
                if(i>0){
                    res -= Math.min(grid[i][j], grid[i-1][j]) * 2;
                }
                if(j>0){
                    res -= Math.min(grid[i][j], grid[i][j-1]) * 2;
                }
            }
        }
        return res;
    }
}

/*
idea:
for each tower, its surface area is 4*v + 2
however, 2 adjacent tower will hide the area of connected part;
the hidden part is min(v1, v2), and we need just substract this
area * 2

Time = O(n^2)
*/
