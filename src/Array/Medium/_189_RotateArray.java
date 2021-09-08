package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            k = k%n;
        }

        int[] newNums = new int[n];
        int j = 0;
        for(int i=n-k; i<n; i++){
            newNums[j++] = nums[i];
        }
        for(int i=0; i<n-k; i++){
            newNums[j++] = nums[i];
        }


        for(int l=0; l<n; l++){
            nums[l] = newNums[l];
        }
    }
}
