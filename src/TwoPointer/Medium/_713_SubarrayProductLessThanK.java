package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k<=1) return 0;
        int prod = 1;
        int l = 0, res = 0;
        for(int r=0; r<n; r++){
            prod *= nums[r];
            while(prod >= k){
                prod /= nums[l];
                l++;
            }
            res += r-l+1;
        }
        return res;
    }
}

/*

  0    1  2  3
[ 10,  5, 2,  6]
  10  50  100 600

res += (0-0+1) + (1-0+1) + (1-1+1) + (3-0+1) = 1 + 2 + 1 + 4
prod = nums[left] * nums[left+1] * ... * nums[right]

  */

