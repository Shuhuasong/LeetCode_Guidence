package DynamicProgramming.Medium;


//Time = O(1)
//Space = O(1690)


public class _264_UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int curr = 0, i2 = 0, i3 = 0, i5 = 0;
        for(int i=1; i<n; i++){
            int ugly = Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));
            nums[i] = ugly;
            if(nums[i2] * 2 == ugly) i2++; //i2 = 1
            if(nums[i3] * 3 == ugly) i3++;
            if(nums[i5] * 5 == ugly) i5++;
        }
        return nums[n-1];
    }

}

/*
because every number can only be divided by 2, 3, 5
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

we can find that every subsequence is the ugly-sequence itself(1, 2, 3, 4, 5) multiple 2, 3, 5
Then we use similar merge method a merge sort, to get every ugly number from the three subsequence
every step we choose the smallest one, and move one steps after, including nums with same value
*/

