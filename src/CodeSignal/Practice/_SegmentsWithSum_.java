package CodeSignal.Practice;

/**
 * Created by Shuhua Song
 */
/*
Given an array of integers a, consider all its contiguous subarrays of length m. Calculate the number of such subarrays, which contain a pair of integers in it with sum greater than or equal to k.

More formally, given the array a, your task is to count the number of such indices 0 ≤ i ≤ a.length - m such that a subarray [a[i], a[i + 1], ..., a[i + m - 1]] contains such pair (a[s], a[t]), such that:

s ≠ t
a[s] + a[t] ≥ k
Example

For a = [2, 4, 2, 7, 1, 6, 1, 1, 1], m = 4, and k = 8, the output should be segmentsWithSum(a, m, k) = 4.
Let's consider all subarrays of length m = 4 and see which of them fit the description conditions:

Subarray a[0..3] = [2, 4, 2, 7] contain a pair (a[0], a[3]) that have sum greater than or equal k: a[0] + a[3] = 2 + 7 + 9 ≥ 8. Note, that there are two more such pairs in the subarray: (a[1], a[3]) and (a[2], a[3]). Also note that there is a pair (a[3], a[3]) having sum 7 + 7 = 14 ≥ 8, but it shoudn't be taken into account, because it violates condition s ≠ t.
Subarray a[1..4] = [4, 2, 7, 1] contains a pair (a[1], a[3]), having a[1] + a[3] = 4 + 7 = 11 ≥ 8. Note, that there is one more such pair in the subarray: (a[3], a[4]).
Subarray a[2..5] = [2, 7, 1, 6] contains a pair (a[2], a[3]), having a[2] + a[3] = 2 + 7 = 9 ≥ 8. Note, that there are three more such pairs: (a[2], a[5]), (a[3], a[4]), and (a[3], a[5]).
Subarray a[3..6] = [7, 1, 6, 1] contains a pair (a[3], a[4]) having the sum equal a[3] + a[4] = 7 + 1 = 8 ≥ 8. Note, that there is one more such pair in the subarray: (a[3], a[5]).
Subarray a[4..7] = [1, 6, 1, 1] doesn't contain any pair having the sum greater than or equal to k = 8.
Subarray a[5..8] = [6, 1, 1, 1] doesn't contain any pair having the sum greater than or equal to k = 8.
Summary, there are 4 subarrays having a pair with sum greater than or equal to k = 8.

For a = [2, 3, 3, 3, 4, 3, 2, 1, 2, 4], m = 2, and k = 7, the output should be segmentsWithSum(a, m, k) = 2.
There are 2 subarrays satisfying the description conditions: a[3..4] = [3, 4] and a[4..5] = [4, 3].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

The given array of integers.

Guaranteed constraints:
2 ≤ a.length ≤ 105,
0 ≤ a[i] ≤ 109.

[input] integer m

The length of subarrays should be considered.

Guaranteed constraints:
2 ≤ m ≤ a.length.

[input] integer k

The requested lower bound for the sum of pair in the subarray.

Guaranteed constraints:
0 ≤ k ≤ 109.

[output] integer

The number of such subarrays, which contain a pair of integers with sum greater than or equal to k.
 */
public class _SegmentsWithSum_ {

    int segmentsWithSum(int[] a, int m, int k) {
        int n = a.length;
        int count = 0;
        for(int i=0; i<=n-m; i++){
            boolean flag = false;
            for(int j=i; j<i+m-1; j++){
                for(int r=j+1; r<i+m; r++){
                    if(a[j]+a[r] >= k){
                        count++;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        return count;
    }

}
