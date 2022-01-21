package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _134_GasStation {

    //Greedy - 2 pass:
    //Time = O(n), Space= O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, total = 0;

        int totalGas = 0, currGas = 0, startPot = 0;
        for(int i=0; i<n; i++){
            currGas += gas[i]-cost[i];
            totalGas += gas[i]-cost[i];
            //If it couldn't move to next station at this point, try next station to start
            if(currGas < 0){
                startPot = i+1;
                //start with an empty tank;
                currGas = 0;
            }
        }
        return totalGas >= 0 ? startPot : -1;
    }

    /*

     //Greedy - 2 pass:
    //Time = O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, total = 0;
        for(int i=0; i<n; i++){
            total += gas[i]-cost[i];
        }
        if(total < 0) return -1;
        int tankGas = 0, startPot = 0;
        for(int i=0; i<n; i++){
            tankGas += gas[i] - cost[i];
            if(tankGas < 0){
                startPot = i+1;
                tankGas = 0;
            }
        }
        return tankGas >= 0 ? startPot : -1;
    }


      //Brute Force: O(n^2)--> TLE
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0; i<n; i++){
            int tank = 0;
            boolean valid = true;
            for(int j=i; j<i+n+1; j++){
                tank += gas[j%n] - cost[j%n];
                if(tank < 0){
                    valid = false;
                    break;
                }
            }
            if(valid) return i;
        }
        return -1;
    }
     */
}

/*
Intuitive:
1) It is impossible to perform the road trip is sum(gas) < sum(cost). In this case, the result is -1;
2) When gas[i] < cost[i], we can't start a station here, since it is not
   enough for go to next (i+1) station, because: gas[i]-cost[i] < 0
3) At any given point, the amount of current totalGas should be greater than or
   equal to the cost in the next station

Solution-1: Brute Force
since we don't know which index is a start, so we need try one by one, we only
    can try to make a circular route from every gas station after a refill.


/*
Set seen =
gas = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}},
cost = {3, 4, 5, 1, 2,3, 4, 5, 1, 2}
*/

