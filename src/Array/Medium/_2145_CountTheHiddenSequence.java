package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _2145_CountTheHiddenSequence {

    public int numberOfArrays(int[] diff, int lower, int upper) {
        int minDiff = Integer.MAX_VALUE, maxDiff = Integer.MIN_VALUE;
        int val = 0, res = 0;
        for(int d : diff){
            val += d;
            minDiff = Math.min(minDiff, val);
            maxDiff = Math.max(maxDiff, val);
        }
        for(int i=lower; i<=upper; i++){
            int start = i+minDiff;
            int end = i+maxDiff;
            System.out.println(start + " " + end);
            if(start >= lower && end <= upper){
                res++;
            }
        }
        return res;
    }

    /*
      public int numberOfArrays(int[] diff, int lower, int upper) {
         long minDiff = 0, maxDiff = 0;
         long val = 0, res = 0;
         for(int d : diff){
             val += d;
             minDiff = Math.min(minDiff, val);
             maxDiff = Math.max(maxDiff, val);
         }
         return (int)Math.max(0, (upper-lower)-(maxDiff-minDiff)+1);
    }
     */
}

/*
Method-1:
Logic:
assume our start number is X,
now we use thd diff array to build a complete array:
diff =  [1,-3,4], lower = 1, upper = 6
newArray = {X, X+1, X-2, X+2}
minDiff = -2, maxDiff = 2

values in range for [val+minDiff, val+maxDiff] are also in range
startNum
    1  - [1-2, 1+2] - [-1, 3] - not in range   max-min = 4
    2  - [2-2, 2+2] - [0, 4]  - not in range   max-min = 4
    3  - [3-2, 3+2] - [1, 5]  - in range       max-min = 4
    4  - [4-2, 4+2] - [2, 6]  - in range       max-min = 4
    5  - [5-2, 5+2] - [3, 7]  - not in range   max-min = 4
    6  - [6-2, 6+2] - [4, 8]  - not in range   max-min = 4

Method-2:
assume the start number is X,
record the curr value, the max and min value in this sequence
now we need to put the sequence with range [min, max]
into a range of [lower, upper]
if  (upper-lower) < max-min, no possible hidden sequence
if  (upper-lower) == max-min, we only have 1 possible
if  (upper-lower) == max-min+1, we have 2 possible
if  (upper-lower) == max-min+k, we have k+1 possible sequence
so, result = (upper-lower) - (max-min) + 1;

ex-1:
diff =  [1,-3,4], lower = 1, upper = 6
preSum = {1, -2, 2}, min = -1, max = 2
ans = (upper-lower) - (max-min) + 1
    = 5-4+1 = 2

ex-2:
diff =   [3,-4,5,1,-2], lower = -4, upper = 5
preSum = {3,-1,4,5, 3}, min = -1, max = 5
ans = (upper-lower) - (max-min)
    = (5+4) - (5+1) + 1 = 4

differences[i] + hidden[i]= hidden[i + 1].
ex-3: use long type
diff = [100000,100000,100000,100000,100000,100000,100000...]
 */
