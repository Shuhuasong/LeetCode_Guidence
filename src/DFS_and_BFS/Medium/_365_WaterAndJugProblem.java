package DFS_and_BFS.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _365_WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y < z) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int[] dirs = {x, -x, y, -y};
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);

        while(!deque.isEmpty()){
            int curr = deque.poll();
            if(curr==z) return true;
            for(int d : dirs){
                int total = curr + d;
                if(curr==z) return true;
                if(total < 0 || total > (x+y)) continue;
                if(seen.contains(total)) continue;
                seen.add(total);
                deque.add(total);
            }
        }
        return false;
    }

    /*
     public boolean canMeasureWater(int x, int y, int z) {
        if(x+y < z) return false;
        return z % gcd(x, y)==0;
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
     */
}

/*
intuitive:
water is always : x or y
we can do operation: +x, -x, +y, -y
Solution-1: BFS
initial state : 0
final state: targetCap
transition HashSet<Integer>

Solution-2: Euclian Algorithm ==> to check is the x and y are coprime
ax + by = z
(GCD) find if z is the multiples of greatest common divisor of x and y

gcd(c, b)
    if(b==0) return a
    else return gcd(b, a%b);
Time = O(log(min(a, b)))
*/

