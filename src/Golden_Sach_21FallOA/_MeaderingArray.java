package Golden_Sach_21FallOA;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _MeaderingArray {

   /* public void meaderingArray(int[] nums){
        if(nums.length==0) return;
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = n-1;
        while(lo < hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
        }
    }*/

    public static void meanderingArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2, k = 0;
        int[] results = new int[n];
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            results[k++] = nums[hi];
            results[k++] = nums[lo];
            lo++;
            hi--;
        }
        if(n%2 != 0){
            results[k] = nums[lo];
        }
        for (int a : results) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 2, 3, -5};
        meanderingArray(nums);
    }
}
