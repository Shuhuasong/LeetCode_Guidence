package TwoPointer.Easy;

public class _167_twoSumII {

    //Two Pointer : Time --O(n)
    //idea: fix the left pointer, move right pointer to find the answer
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum==target){
                return new int[]{left+1, right+1};
            }
            if(sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }


    //The array is sorted, so the Binary Search can be used
    //Time: O(nlogn)
 /*    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0) return new int[]{-1, -1};
        int n = numbers.length;
        int j = 0;
        for(int i=0; i<n; i++){
            j = binarySearch(numbers, target-numbers[i]);
            if(j!=-1){
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, 1};
    }

    private int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid;
            }else if(nums[mid]>target){
                right = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

  */
}
