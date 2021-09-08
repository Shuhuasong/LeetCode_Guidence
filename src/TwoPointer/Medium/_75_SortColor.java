package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _75_SortColor {


    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        int n = nums.length;
        int left = 0, mid = 0, right = n-1;
        while(mid <= right){
            if(nums[mid]==1) mid++;
            else if(nums[mid]==0){
                nums[mid] = nums[left];
                nums[left] = 0;
                mid++;
                left++;
            }else{
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}
