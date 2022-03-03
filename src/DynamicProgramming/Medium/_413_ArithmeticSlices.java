package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _413_ArithmeticSlices {

    //Time = O(n), Space = O(n)
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, sum = 0;
        int[] dp = new int[n];
        for(int i=2; i<n; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }

    /*
    //DP : Time = O(n), Space = O(n)
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        cutArray(A, A.length-1);
        return sum;
    }
    private int cutArray(int[] A, int end){
        if(end < 2) return 0;
        int currRes = 0;
        if(A[end]-A[end-1]==A[end-1]-A[end-2]){
            //extend the range of slice and add one additional slide
            currRes = 1 + cutArray(A, end-1);
            sum += currRes;
        }else{
            //not extend the range
            cutArray(A, end-1);
        }
        return currRes;
    }
    */



    /* //Brute force
     public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            //just check the last pair to have the same difference
            //as the one used for previous range
            for (int e = s + 2; e < A.length; e++) {
                if(A[e]-A[e-1]==d){
                    count++;
                }else{
             //if the current diff is not the same, change a start point
                    break;
                }
            }
        }
        return count;
    }
     */


/*
    //Sliding Window: Time = O(n^2), Space = O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int l = 0, res = 0,n = nums.length;
        int r;
        for(r=1; r<n; r++){
            if(r>1 && nums[r]-nums[r-1]==nums[r-1]-nums[r-2]) continue;
            else if((r-l+1)>=3){
                res += countSubarray(l, r);
            }
            l = r;
        }
        res += countSubarray(l, r);
        return res;
    }

    private int countSubarray(int l, int r){
        int totalLen = r-l+1;
        int res = 0, window = 3;
        while(window<=totalLen){
            res += (totalLen-window)+1;
            window += 1;
        }
        return res;
    }

 */

}

/*
A  = {1, 3, 5, 7, 9, 15, 20, 25, 28, 29}
dp = {0, 0, 1, 2, 3,  0,  0,  1,   0, 0}

A = [1,3,5,7,9]
subArray: {1,3,5}, {3,5,7},{5,7,9},{1,3,5,7},{3,5,7,9}
{1,3,5,7,9}
*/


