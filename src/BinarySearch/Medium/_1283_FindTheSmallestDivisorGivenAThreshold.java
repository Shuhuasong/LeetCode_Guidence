package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _1283_FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0;
        for(int num : nums){
            hi = Math.max(hi, num);
        }
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int sum = 0;
            for(int num : nums){
                if(num < mid) sum++;
                else{
                    sum += num/mid;
                    sum += (num%mid==0 ? 0 : 1);
                }
            }
            if(sum > threshold){
                lo = mid + 1;
            }else{
                //when sum <= threshold, it means we can use the divisor
                //hten explor a smaller one
                hi = mid - 1;
            }
        }
        return lo;
    }
}
