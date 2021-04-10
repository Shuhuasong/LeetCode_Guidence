package Array.Medium;

public class _775_GlobalAndLocalInversions {

    //Time = O(n) Space  = O(1)
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int floor = n;
        for(int i=n-1; i>=2; i--){
            floor = Math.min(floor, nums[i]);
            if(nums[i-2] > floor) return false;
        }
        return true;
    }


    //Time = O(n^2) Space  = O(1)
 /*   public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+2; j<n; j++){
                if(nums[i] > nums[j]) return false;
            }
        }
        return true;
    }


  */

}
