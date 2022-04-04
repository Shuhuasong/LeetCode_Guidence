package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        //find first decreasing pair
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            //find the right element that is just larger than nums[i]
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int i = start, j = nums.length-1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

/*
        0  1  2  3  4  5  6  7
nums = {1, 2, 7, 8, 5, 6, 4, 3}
                    i  j

                    */

