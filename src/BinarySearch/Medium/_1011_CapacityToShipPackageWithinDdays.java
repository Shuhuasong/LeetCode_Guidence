package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _1011_CapacityToShipPackageWithinDdays {

    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for(int w : weights){
            lo = Math.max(lo, w);
            hi += w;
        }
        while(lo <= hi){
            //find a good capacity
            int mid = lo + (hi-lo)/2;
            int numDays = 1, sum = 0;
            for(int w : weights){
                if((sum+w) > mid){
                    numDays++;
                    sum = w;
                }else{
                    sum += w;
                }
            }
            if(numDays > days){
                lo = mid + 1;
            }else{
                //when numDays <= days, it means we can ship, then we explor less days
                hi = mid - 1;
            }
        }
        return lo;
    }
}


/*
Given the number of bags,
return the minimum capacity of each bag,
so that we can put items one by one into all bags.
we can binary search the final result.
the left bound is max(A), the right bound is sum(A)

    More Good Binary Search Problems
Here are some similar binary search problems.

1482. Minimum Number of Days to Make m Bouquets
1283. Find the Smallest Divisor Given a Threshold
1231. Divide Chocolate
1011. Capacity To Ship Packages In N Days
875. Koko Eating Bananas
774. Minimize Max Distance to Gas Station
410. Split Array Largest Sum
*/


