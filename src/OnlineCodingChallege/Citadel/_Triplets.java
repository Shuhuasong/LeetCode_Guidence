package OnlineCodingChallege.Citadel;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _Triplets {

    private static int numTriplets(int[] nums, int target){
        if(nums==null || nums.length==0 || nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for(int i=0; i<n-2; i++){
            int left = i+1, right = n-1;
            while(left  < right){
                int  sum = nums[i]+nums[left]+nums[right];
                System.out.println(nums[i] + " " + nums[left] + " " + nums[right] + " " + sum);
                while(left < right && sum > target) {
                    right--;
                    sum = nums[i]+nums[left]+nums[right];
                }
               // if(left < right){
                count += right-left;
                //break;
               // }
               left++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 8;
        System.out.println(numTriplets(nums, target));
    }
}
