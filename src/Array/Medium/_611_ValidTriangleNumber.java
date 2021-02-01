package Array.Medium;

import java.util.Arrays;

public class _611_ValidTriangleNumber {

    //Linear Scan Time = O(n^2)  Space = O(log n)
    public int triangleNumber(int[] nums) {
        int result = 0, n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            int k = i+2;
            for(int j=i+1; j<n-1 && nums[i]!=0; j++){
                while(k<n && nums[i]+nums[j] > nums[k]){
                    k++;
                }
                result += k-j-1;
            }
        }
        return result;
    }
}
