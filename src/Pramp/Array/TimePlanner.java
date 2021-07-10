package Pramp.Array;

/*
Time Planner
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies the duration requirement, return an empty array.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.

Implement an efficient solution and analyze its time and space complexities.

Examples:

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 8
output: [60, 68]

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 12
output: [] # since there is no common slot whose duration is 12
Constraints:

[time limit] 5000ms

[input] array.array.integer slotsA

1 ≤ slotsA.length ≤ 100
slotsA[i].length = 2
[input] array.array.integer slotsB

1 ≤ slotsB.length ≤ 100
slotsB[i].length = 2
[input] integer

[output] array.integer
 */


public class TimePlanner {
    static int[] meetingPlanner(int[][] A, int[][] B, int dur) {
        // your code goes here
        int[] result = new int[2];
        if(dur==0) return result;
        int i = 0, j = 0;
        int stA = -1, endA = -1, stB = -1, endB = -1;
        int m = A.length, n = B.length;
        int start = -1, end = -1;
        while(i < m && j < n){
            stA = A[i][0]; endA = A[i][1];
            stB = B[j][0]; endB = B[j][1];
            if(stB > endA || stA > endB){
                if(endA > endB) { j++; }
                else{
                    i++;
                }

            }else{
                start = Math.max(stA, stB);
                end = Math.min(endA, endB);
                if( (end-start) >= dur){
                    return new int[]{start, start + dur};
                }
            }
        }
        return new int[]{};
    }

    /*
    Pseudocode:


    function meetingPlanner(slotsA, slotsB, dur):
    ia = 0
    ib = 0

    while (ia < slotsA.length AND ib < slotsB.length):
        start = max(slotsA[ia][0], slotsB[ib][0])
        end = min(slotsA[ia][1], slotsB[ib][1])

        if (start + dur <= end):
            return [start, start + dur]

        if (slotsA[ia][1] < slotsB[ib][1]):
            ia++
        else:
            ib++

    return []

     */
}
