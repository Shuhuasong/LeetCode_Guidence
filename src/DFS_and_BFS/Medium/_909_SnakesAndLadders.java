package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _909_SnakesAndLadders {
    //BFS
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        q.offer(1);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                //if possible reach the end, return steps
                if(curr==n*n) return steps;
                for(int j=1; j<=6; j++){
                    int num = curr+j;
                    if(num > n*n) break;
                    int row = n-(num-1)/n-1;
                    int col = (n-row)%2 != 0 ? (num-1)%n : n-(num-1)%n-1;
                    if(!visited[num]){
                        visited[num] = true;
                        if(board[row][col]==-1){
                            q.offer(num);
                        }else{
                            q.offer(board[row][col]);
                        }
                    }
                }
            }
            steps++;
        }
        //reach here, it means it is not possible to reach the end
        return -1;
    }
}

/*
intuitive soulution--BFS (find shortest path in unweighted graph)
1) convert number to index on board(x, y), e.g num = 9 ==> row = 4, col = 3
   row = n - (num-1)/n - 1 = 6-(9-1)/6-1 = 4
   col : check if (n-row)%2==0 ===> col = n-(num-1)%n-1
              if (n-row)%2 != 0 ===>

2) move rule: {x+1, x+2, x+3,...., x+6} or the end of the snake or ladder

3) there are many ways to reach the n*n cell, so need to try all possibilities,
   and keep a global minimum result. But since we use the BFS, the quickest path will reach earliest
   or cannot reach n*n, then return -1

*/

