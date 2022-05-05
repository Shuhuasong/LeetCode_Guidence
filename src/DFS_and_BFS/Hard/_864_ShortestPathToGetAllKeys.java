package DFS_and_BFS.Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _864_ShortestPathToGetAllKeys {
    class State{
        int x, y;
        int keys;
        public State(int x, int y, int keys){
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startX = -1, startY = -1, maxKeys = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = grid[i].charAt(j);
                if(c >= 'a' && c <= 'f'){
                    maxKeys = Math.max(c-'a'+1, maxKeys);
                }
                if(c=='@'){
                    startX = i;
                    startY = j;
                }
            }
        }
        //"abc"==111 = 7
        int totalKeys = (1 << maxKeys)-1;
        State start = new State(startX, startY, 0);
        Queue<State> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> visited = new HashSet<>();
        visited.add(startX+","+startY+","+0);
        q.add(start);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                State curr = q.poll();
                //return result if we got all keys
                if(curr.keys == totalKeys) return steps;
                for(int[] dir : dirs){
                    int nx = dir[0]+curr.x, ny = dir[1]+curr.y;
                    //keys for current state
                    int keys = curr.keys;
                    if(nx>=0 && nx<m && ny>=0 && ny<n){
                        char ch = grid[nx].charAt(ny);
                        //wall, can't walk
                        if(ch=='#') continue;
                        //find a key
                        if(ch>='a' && ch<='f'){
                            keys = keys | (1<<(ch-'a'));
                        }
                        //find a lock, but without a key
                        if(ch>='A' && ch<='F' && ((keys) >> (ch-'A') & 1)==0) continue;
                        if(!visited.contains(nx+","+ny+","+keys)){
                            visited.add(nx+","+ny+","+keys);
                            q.add(new State(nx, ny, keys));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}


/*
Solution-BFS
1) find the start point, and the total number of keys.
2) the char of key show up in order, so we represent keys
   by use max. e.g  the max alphabet is c, then max = 4
3) We need to comfirm all 'abc' are collected, so we use
   bit represent all alphabet.
   e.g if we get 'c', then keys = 100,
       if we get 'a', then keys = 101,
       if we get 'b', then keys = 111
4) we can check if (1<<max)-1==keys, then all keys are collected

*/