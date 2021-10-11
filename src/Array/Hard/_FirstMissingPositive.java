package Array.Hard;

/**
 * Created by Shuhua Song
 */
/*
Algorithm

Now everything is ready to write down the algorithm.

--Check if 1 is present in the array. If not, you're done and 1 is the answer.
--Replace negative numbers, zeros, and numbers larger than n by 1s.
--Walk along the array. Change the sign of a-th element if you meet number a.
  Be careful with duplicates : do sign change only once. Use index 0 to save
  an information about presence of number n since index n is not available.
--Walk again along the array. Return the index of the first positive element.
--If nums[0] > 0 return n.
--If on the previous step you didn't find the positive element in nums, that means that the answer is n + 1.

 */
public class _FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        boolean withOne = false;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                withOne = true;
            }
            //replace negative number, zeros, nums[i] > n to 1
            //array only contains positive numbers
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }
        //base can, if there is no 1, return 1
        if(!withOne) return 1;
        //Use index as a hash key and number sign as a present detector
        //e.g. if nums[1] is negative, then the number 1 is present
        // if nums[2] is positive, then number 2 is missing
        for(int i=0; i<n; i++){
            //if meet num[i], set it to negative
            //be careful with the duplicate : do it only once
            int a = Math.abs(nums[i]);
            if(a==n){
                nums[0] = -Math.abs(nums[0]);
            }else{
                nums[a] = -Math.abs(nums[a]);
            }
        }
        //Now the index of the first positive number is equal to first missing positive
        for(int i=1; i<n; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0){ //if(nums[0] > 0), then there is no n, then return n
            return n;
        }
        return n+1;
    }
}
