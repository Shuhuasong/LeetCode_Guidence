package DFS_and_BFS.Medium;


/*
Idea:
-- By using BFS, we can generate all possilbe of lock from "0000" to "9999", with 10000 nodes in total
-- for each steps, we generate neighbors of current lock state(by turning clockwise or counter-clockwise of
   4 circular wheels) and check if the neighbor is in the deadends
-- if we meet the target, then the current steps is the minimum steps to open the lock
Complexity:
Time = O(N^2 * A^N + D), N = # of dials(4 in our case), A is # of alphabet(10 in our case), D is size of deadend
-- There are 10^4 possible combination each turning
-- for each combination, we are looping 4 times(=N) and in each iteration, there is form a new string, which take O(N^2)
-- O(D) to create the hashSet
Space = O(A^N) , worst case = # of combination
 */

import java.util.*;

public class _752_OpenTheLock {

    //Time = O(N^2 * A^N + D)  Space = O(A^N), N = length(target), A = #digit(1-9), D = length(deadends)
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String d : deadends){ dead.add(d); }
        if(dead.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String node = q.poll();
                if(node.equals(target)) return steps;
                List<String> neighbors = getNeighbors(node);
                for(String nei : neighbors){
                    if(dead.contains(nei)) continue;
                    dead.add(nei);
                    q.add(nei);
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> getNeighbors(String code){
        List<String> neis = new ArrayList<>();
        for(int i=0; i<4; i++){
            int a = code.charAt(i)-'0';
            for(int d=-1; d<=1; d += 2){
                int b = (a + d + 10)%10;
                String newS = code.substring(0, i) + (b+"") + code.substring(i+1);
                neis.add(newS);
            }
        }
        return neis;
    }
}
