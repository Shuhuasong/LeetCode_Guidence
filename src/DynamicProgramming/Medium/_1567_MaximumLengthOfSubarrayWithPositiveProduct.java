package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _1567_MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int numNeg = 0; // count the number of negative number from prevZeroPos to current index
        int firstNegaPos = -1, resLen = 0;
        int prevZeroPos = -1;
        for(int i=0; i<n; i++){
            if(nums[i] < 0){
                numNeg++;
                //record the first position of negative number
                if(firstNegaPos==-1) firstNegaPos = i;
            }
            if(nums[i]==0){ //zero will make product to zero, so reset the game by resetting the variables
                numNeg = 0;
                firstNegaPos = -1;
                prevZeroPos = i;
            }
            else{
                if(numNeg % 2==0){
                    //with even number of Negative, the window is between [prevZeroPos, i]
                    resLen = Math.max(resLen, i-prevZeroPos);
                }else{
                    //with odd number of Negative, the window is between [firstNegaPos, i];
                    resLen = Math.max(resLen, i-firstNegaPos);
                }
            }
        }
        return resLen;
    }
}
