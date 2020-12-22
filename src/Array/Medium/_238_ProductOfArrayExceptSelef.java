package Array.Medium;

public class _238_ProductOfArrayExceptSelef {

    //Time = O(n)  Space = O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];

        results[0] = 1;
        for(int i=1; i<n; i++){
            results[i] = results[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
            results[i] = results[i] * right;
            right = right * nums[i];
        }
        return results;
    }

    //Time = O(n)  Space = O(n)
 /*   public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i=0; i<n; i++){
            results[i] = left[i] * right[i];
        }
        return results;
    }

  */

}
