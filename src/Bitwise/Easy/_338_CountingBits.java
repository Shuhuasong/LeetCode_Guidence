package Bitwise.Easy;

/**
 * Created by Shuhua Song
 */
public class _338_CountingBits {


    //DP + least Significant Bit
    //Time = o(n)
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int v=1; v<=num; v++){
            ans[v] = ans[v/2] + (v & 1);
        }
        return ans;
    }

    /*
     //DP + Last Set Bit
    //Time = o(n)
    public int[] countBits(int num) {
       int[] ans = new int[num+1];
       for(int v=1; v<=num; v++){
           ans[v] = ans[v & (v-1)] + 1;
       }
       return ans;
    }
     */


    //DP : Time = O(n)
/*    int[] memo;
    public int[] countBits(int num) {
        if(num==0) return new int[]{0};
        int[] res = new int[num+1];
        memo = new int[num+1];
        memo[1] = 1;
        for(int i=2; i<=num; i++){
            memo[i] = countBit(i);
        }
        return memo;
    }
    private int countBit(int val){
        if(val % 2 == 0){
            memo[val] = memo[val/2] + memo[val%2];
        }else{
            memo[val] = memo[val-1] + 1;
        }
        return memo[val];
    } */


    /* //Brute Force
     public int[] countBits(int num) {
       int[] res = new int[num+1];
       for(int i=0; i<=num; i++){
           res[i] = countBit(i);
       }
       return res;
    }
    private int countBit(int val){
        int count = 0;
        while(val > 0){
            if((val & 1) > 0){
                count++;
            }
            val = val >> 1;
        }
        return count;
    }
     */
}


/*
Solution-2:
        DP + least Significant Bit
        a = (101) = 5
        b = (10) = 2
        a can be consider as the results of removing the least significant bit of x
        5 = 5/2 + (5 mod 2)
        P(x) = P(x/2) + (x mod 2)

        ans[0] = 0
        ans[1] =  ans[1/2] + (1 & 1)  = ans[0] + (1 & 1) = 1
        ans[2] =  ans[2/2] + (2 & 1)  = ans[1] + (2 & 1) = 1
        ans[3] =  ans[3/2] + (3 & 1)  = ans[1] + (3 & 1) = 1 + 1 = 2
        ans[4] =  ans[4/2] + (4 & 1)  = ans[2] + (4 & 1) = 1 + 0 = 1

        Solution-3:
        DP + Last Set Bit : set the rightmost set bit to zero ==> x &= x-1
        P(x) = P(x & (x-1)) + 1
        ans[0] = 0
        ans[1] = ans[1 & 0] + 1 = ans[0] + 1 = 1
        ans[2] = ans[2 & 1] + 1 = ans[0] + 1 = 1
        ans[3] = ans[3 & 2] + 1 = ans[2] + 1 = 1 + 1 = 2
        ans[4] = ans[4 & 3] + 1 = ans[0] + 1 = 0 + 1 = 1
        ans[5] = ans[5 & 4] + 1 = ans[4] + 1 = 1 + 1 = 2
 */