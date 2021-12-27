package Bitwise.Medium;

/**
 * Created by Shuhua Song
 */
public class _1680_ConcatenationOfConsecutiveBinaryNumber {

    /*
     //Time = O(n), Space = O(1)
    public int concatenatedBinary(int n) {
        int MOD = (int)1e9+7;
        int length = 0; // bit length of addends
        long result = 0; // long accumulator
        for(int i=1; i<=n; i++){
            //when i is teh power of two, increase the bit length
            if((i & (i-1))==0) {
                length++;
            }
            result = ((result << length | i)) % MOD;
        }
        return (int) result;
    }
     */

    //Time = O(nlogn) , Space = o(nlogn)
 /*   public int concatenatedBinary(int n) {
        int MOD = (int)1e9+7;
        int res = 0;
        for(int i=1; i<=n; i++){
            String binary = Integer.toBinaryString(i);
            for(int j=0; j<binary.length(); j++){
                res = (2*res + (binary.charAt(j)-'0')) % MOD;
            }
        }
        return res;
    }  */
}

/*
/*
n = 3
i = 1  --->  "1"
i = 2  --->  "10" ===> 1 1 0  ----> shift left two position
i = 3  --->  "11" ===> 1 1 0 1 1    (1)
1 10 11 ---> 27
Solution 2:
(1) Moving "two" unit left is because 3 (binary 11) has a length of 2.
    To find out the length of binary of a number, we can use base 2.
    we can record current length, and increase it when we meet a power of 2

Algorithm

Step 1: Initialize an integer result to store the final result.

Step 2: Iterate from 1 to n. For each number i:

Find the length of the binary representation of the number. Denote by length.
Update result to \text{result} \cdot 2^{\text{length}} + iresult⋅2
length
 +i.
Step 3: Return result.

Solution-3: (bitwise operation)
we can use (x & (x-1)) == 0 to check if x is the power of 2
e.g.  4 & 3 = 100 & 011 = 0
       << 2 , bitwise shift
1 1 0 -------------------> 1 1 0 0 0

           | 3, bitwise or
1 1 0 0 0 ------------------> 1 1 0 1 1

*/
