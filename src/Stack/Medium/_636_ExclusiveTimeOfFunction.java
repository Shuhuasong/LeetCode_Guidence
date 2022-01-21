package Stack.Medium;

import java.util.List;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _636_ExclusiveTimeOfFunction {

    //Time = O(n), Space = On/2
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int id = -1, currTime = -1, prev = -1;
        for(String log : logs){
            String[] strs = log.split(":");
            id = Integer.parseInt(strs[0]);
            currTime = Integer.parseInt(strs[2]);  //currTime = 2
            if(strs[1].charAt(0)=='s'){
                if(!stack.isEmpty()){
                    res[stack.peek()] += currTime-prev;  //Add (2-0) into id = 0
                }
                stack.push(id);
                prev = currTime;
            }else{ //"end": need to add 1, currTime = 5
                res[stack.peek()] += currTime - prev + 1; //add (5-2)+1
                stack.pop();
                prev = currTime + 1;
            }
        }
        return res;
    }
}

/*

Intuitive: Method-- Simulation by using Stack
When a function is called, pause the current (top)
    function and push new function to the stack
case-1:
"0:start:0",
"1:start:2",
"1:end:5",
"0:end:6"
0   1   2   3   4   5   6   7
|___0___|               |_0_|
        |________1______|

id  start-end  duration
0  : 0----2      2
1  : 2----6      4
0  : 6----7      1
output: [3, 4]

case-2:
"0:start:0",
"0:start:2",
"0:start:3",
"0:end:3",
"0:end:4",
"0:end:6"
0   1   2   3   4   5   6   7
|_______|           |_______|
        |___|   |___|
            |___|

id  start-end  duration
0  : 0----2      2
0  : 2----3      1
0  : 3----4      1
0  : 4----5      1
0  : 5----7      2

output: [7]
*/


