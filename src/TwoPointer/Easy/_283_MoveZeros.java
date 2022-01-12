package TwoPointer.Easy;

/**
 * Created by Shuhua Song
 */
public class _283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for(int r=0; r<nums.length; r++){
            if(nums[r] != 0){
                nums[l] = nums[r];
                l++;
            }
        }
        while(l < nums.length){
            nums[l++] = 0;
        }
    }
}
