package Math.Medium;

/**
 * Created by Shuhua Song
 */
public class _2162_MinimumCostToSetCookingTime {
    //Time = O(9999) =  O(10^4)
    //Space = O(1)
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int target) {
        int res = Integer.MAX_VALUE;
        for(int time=1; time<=9999; time++){
            String t = time+"";
            while(t.length() != 4){
                t = "0" + t;
            }
            //calculate total seconds
            int total = ((t.charAt(0)-'0')*10 + (t.charAt(1)-'0')) * 60 +  //minutes
                    (t.charAt(2)-'0')*10 + (t.charAt(3)-'0'); //seconds
            if(total==target){
                String s = time+"";
                int cost = 0;
                char prevNum = (char)(startAt+'0');
                for(char c : s.toCharArray()){
                    if(c==prevNum){
                        cost += pushCost;
                    }else{
                        cost += moveCost + pushCost;
                    }
                    prevNum = c;
                }
                res = Math.min(res, cost);
            }
        }
        return res;
    }
}

/*
There are may be several edges cases for a time:
e.g
case-1: target = 611
minutes = target/60 = 10
seconds = 11
time display:
1) 10:11
2) 09:71
3)  9:71

case-2: target = 76
minutes = 1
seconds = 16
1) 1:16
2) 01:16
3) 0:76
4) 00:76
5)   :76

Better solution:
To avoid analysing lots of edges cases.  We can use a for loop
to iterate the time from 1 to 9999, and them use this mocrowive format
time to calculate the total seconds. Then, check if this time is the same
with our target. If the same, we store in our result and complare which one s
minimum


9
100000
1
6039
*/
