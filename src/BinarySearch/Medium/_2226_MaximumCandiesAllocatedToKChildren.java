package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _2226_MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int start = 1, end = 0;
        for(int c : candies) end = Math.max(end, c);
        long res = 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            long count = getCount(candies, mid);
            if(count>=k){
                res = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int)res;
    }

    private long getCount(int[] candy, int mid){
        long count = 0;
        for(int c : candy){
            count += c/mid;
        }
        return count;
    }
}
