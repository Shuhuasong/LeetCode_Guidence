package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _926_FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        if(s.length()<=1) return 0;
        int n = s.length();
        int[] preOne = new int[n+1];
        for(int i=0; i<n; i++){
            preOne[i+1] = preOne[i] + ((s.charAt(i)=='1') ? 1 : 0);
        }
        int totalOne = preOne[n];
        int res = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++){
            res = Math.min(res, preOne[i]+ (n-i) -(preOne[n]-preOne[i]));
        }
        return res;
    }
}

/*
Solution-Presum
1) calculate the preSum for the number of ones
2) the answer of the array will be left half part(zero), right half part(one)
   so, we only need to calculate how many ones in the left half and how many zeros
   are in the right half.
        0  1  2  3  4  5
      " 0  1  0  1  1  0"
preOne  0, 0, 1, 1, 2, 3, 3  ,
if evalutate the number of zeros at index x = 3
preOne[3] = 1 number of ones in the first 3 characters, and P[6]-P[3] = 2 ones
in the later N-x = 6-3=3 characters,
So, there is (N-x)-(P[N]-P[x]) = 1 number of zero in the later N-x characters

  */
