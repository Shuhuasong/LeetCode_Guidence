package DynamicProgramming.Medium;

import java.util.Arrays;

public class _1690_StoneGame_VII {

    /*
Alice: wants to maximize her score difference with Bob, so she needs to know Bob’s difference in order to makes a particular choice. Therefore, the question can’t use greedy, it must use Dynamic programming (Recursive problem)
Bob: wants to minimize his score difference with Alice

Step 1: scoreRemoveFirst = sum(stones[start+1] to stones[end] )
              scoreRemoveLast = sum(stones[start] to stones[end-1] )
Step 2:
Bob will try to return the maximum negative value, so the difference between his and Alice’s score is minimum.
Alice will try to return the maximum positive value, so the difference between here and Bob’s score is maximum.
findDifference(start, end, alice) : return the difference in score for a player in [start, end]. Alice is a boolean value. Each player would recursively calculate the difference that another player would return

Bob’s difference = Alice’s difference - Current Score
Since we are finding the maximum negative value, so we will use min()

findDifference(start, end, false) = min (
//if Bob removes first stone
findDifference(start+1, end, true) – scoreRemoveFirst,
//if Bob removes last stone
findDifference(start, end-1, true) – scoreRemoveLast )

Alice’s difference = Bob’s difference + Current Score
Since Bob’s difference would be a negative value, we would add the Current Score of Alice to find the maximum positive difference

findDifference(start, end, false) = max (
//if Alice removes first stone
findDifference(start+1, end, true) +  scoreRemoveFirst,
//if Alice removes last stone
findDifference(start, end-1, true) +  scoreRemoveLast )


*/
    //Time = O(n^2),  For all possible subarray in array stones, we calculate it's result only once. Since there are n^2
    //  possible subarrays for an array of length nn, the time complexity would be n^2
    //Space = O(n^2)
    int[] prefixSum;
    final int MAX = Integer.MAX_VALUE;
    int[][] memo;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new int[n][n];
        for(int[] arr : memo){
            Arrays.fill(arr, MAX);
        }
        prefixSum = new int[n+1];
        for(int i=0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + stones[i];
        }
        return Math.abs(findDifference(0, n-1, true)); //True = Alice, False = Bob
    }

    private int findDifference(int start, int end, boolean alice) {
        if (start == end) {
            return 0;
        }
        if (memo[start][end] != MAX) {
            return memo[start][end];
        }
        int difference;
        int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
        int scoreRemoveLast = prefixSum[end] - prefixSum[start];

        if (alice) {
            difference = Math.max( //!alice = bob
                    findDifference(start + 1, end, !alice) + scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) + scoreRemoveLast);
        } else {
            difference = Math.min( //!alice = !bob = alice
                    findDifference(start + 1, end, !alice) - scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) - scoreRemoveLast);
        }
        memo[start][end] = difference;
        return difference;
    }

}
