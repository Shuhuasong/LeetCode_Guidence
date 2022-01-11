package SlidingWindow.Medium;

/**
 * Created by Shuhua Song
 */
public class _2134_MinimumSwapsToGroupsAll1sTogetherII {
    public int minSwaps(int[] nums) {
        int n = nums.length, ones = 0, maxOneInWindow = 0;
        int count = 0;
        for(int num : nums){
            if(num==1) ones++;
        }
        int[] newNums = new int[2*n];
        for(int i=0; i<2*n; i++){
            newNums[i] = nums[i%n];
        }
        for(int i=0; i<2*n; i++){
            if(newNums[i]==1) count++;
            if(i>=ones && newNums[i-ones]==1) count--;
            maxOneInWindow = Math.max(count, maxOneInWindow);
        }
        return ones-maxOneInWindow;
    }
}


/*
Intuitive:
Whenever we have circular array question, we can append the array to itself to get rid of the
circular array part of the problem.
Solution Steps:
1) Count the number of ones in array, with variable 'ones';
2) Append the nums to itself because we look it as a circular array;
3) Find the maximum number of ones in a size of 'ones' window in a new array;
4) Then the #swap = 'ones'- max # of ones in the window;
*/












    