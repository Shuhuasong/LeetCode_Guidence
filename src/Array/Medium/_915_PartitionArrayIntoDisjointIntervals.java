package Array.Medium;

public class _915_PartitionArrayIntoDisjointIntervals {
    //idea: max(left) <= min(right)
    //Time = O(n) , Space = O(n)
    public int partitionDisjoint(int[] nums) {
        if(nums==null || nums.length<1) return 0;
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        int val = nums[0];
        for(int i=0; i<n; i++){
            val = Math.max(val, nums[i]);
            maxLeft[i] = val;
        }
        val = nums[n-1];
        for(int i=n-1; i>=0; i--){
            val = Math.min(val, nums[i]);
            minRight[i] = val;
        }
        for(int i=0; i<n-1; i++){
            if(maxLeft[i] <= minRight[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}
