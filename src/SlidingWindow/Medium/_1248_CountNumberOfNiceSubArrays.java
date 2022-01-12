package SlidingWindow.Medium;

/**
 * Created by Shuhua Song
 */
public class _1248_CountNumberOfNiceSubArrays {

    //Math Method
    //Time = O(n)
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k-1);
    }

    private int atMost(int[] A, int k){
        int n = A.length, res = 0;
        int l = 0;
        for(int r=0; r<n; r++){
            k -= A[r]%2;
            while(k < 0){
                k += A[l]%2;
                l++;
            }
            res += r-l+1;
        }
        return res;
    }

    //Math Method
    //Time = O(n)
 /*   public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, res = 0;
        int numOdd = 0;
        for(int num : nums) numOdd += num%2;
        int[] oddIdx = new int[numOdd+2];
        oddIdx[0] = -1;
        oddIdx[numOdd+1] = n;
        int idx = 1;
        for(int i=0; i<n; i++){
            if(nums[i]%2==1){
                oddIdx[idx++] = i;
            }
        }
        for(int a : oddIdx){
            //System.out.print(a + " ");
        }
        for(int j=1; j+k<=numOdd+1; j++){
            res += (oddIdx[j]-oddIdx[j-1]) * (oddIdx[j+k]-oddIdx[j+k-1]);
        }
        return res;
    }  */

    /*
     //Time = O(n^3)
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, res = 0;
        for(int s=0; s<n; s++){
            for(int e=s; e<n; e++){
                int count = 0;
                for(int m=s; m<=e; m++){
                    count += (nums[m]%2);
                }
                if(count==k) res++;
            }
        }
        return res;
    }
     */
}

/*
        0  1  2  3  4
nums = {0, 1, 1, 0, 1}

oddIndex = {-1, 1, 2, 4}
                |   |
#odd on left = 1-(-1) = 2
#odd on right= 4-2 = 2
curr # nice sub-array = (oddIdx[i]-oddIdx[i-1]) * (oddIdx[i+k]-oddIdx[i+k-1])
*/
