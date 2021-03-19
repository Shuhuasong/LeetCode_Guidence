package DynamicProgramming.Medium;

public class _376_WiggleSubsequence {


  /*  solution #1:
      Any element in the array could correspond to only one of the following
      three possible states:
      1. up position : nums[i] > nums[i-1]
      2. down position: nums[i] < nums[i-1]
      3. equals to position: nums[i] == nums[i-1]

      if(nums[i] > nums[i-1]), that means it is wiggle up. The element before it must be down position, so up[i] = down[i-1] + 1, down[i] = down[i-1]
      if(nums[i] < nums[i-1]), that means it is wiggle down. The element before it must be up position, so down[i] = up[i-1] + 1, up[i] = up[i-1]
      if(nums[i] == nums[i-1]), that means it is wiggle up. The element before it must be down position, so up[i] = up[i-1] + 1, down[i] = down[i-1] + 1

  */
    //Time = O(n) Space = O(n)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else if(nums[i]-nums[i-1] > 0){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[n-1], up[n-1]);
    }

    /* solution #2
     //Time = O(n) Space = O(1)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        int up = 1, down = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
     */

    /*
    Solution #3:

    greedy: to maintain a variable prevDiff,
    if prevDiff > 0, then we need to look for a decreasing wiggle now;
    if prevDiff < 0, then we need to look for a increasing wiggle now;

     //Time = O(n) Space = O(1)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        int prevDiff = nums[1]-nums[0];
        int count = prevDiff == 0 ? 1 : 2;
        for(int i=2; i<n; i++){
            int currDiff = nums[i]-nums[i-1];
            if(prevDiff >= 0 && currDiff < 0 || prevDiff <= 0 && currDiff >0){
                count++;
                prevDiff = currDiff;
            }
        }
        return count;
    }

     */
}
