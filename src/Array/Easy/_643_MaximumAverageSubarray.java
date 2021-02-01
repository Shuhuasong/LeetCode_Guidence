package Array.Easy;

public class _643_MaximumAverageSubarray {

    //sliding window  Time = O(n)  Space = O(1)
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        double maxVal = sum;
        for(int i=k; i<nums.length; i++){
            sum += nums[i] - nums[i-k];
            maxVal = Math.max(maxVal, sum);
        }
        return maxVal/k;
    }

    /*
     public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        double sum = 0;
        int i=0;
        for(int j=0; j<nums.length; j++){
            sum += nums[j];
            if(j-i+1==k){
                System.out.println(sum);
                result = Math.max(result, sum);
                sum -= nums[i];
                i++;
            }
        }
         System.out.println(result + "#"  + k);
        //double ans = result/k * 0.0;
        return result/k;
    }
     */
}
