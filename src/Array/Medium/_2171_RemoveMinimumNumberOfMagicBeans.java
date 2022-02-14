package Array.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _2171_RemoveMinimumNumberOfMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long count = Long.MAX_VALUE;
        int n = beans.length;
        long total = 0;
        for(int i=0; i<n; i++){
            total += beans[i];
        }
        for(int i=0; i<n; i++){
            //Note: need to convert (n-i)*beans[i] to long type
            long remove = total - (n-i+0l)*beans[i];
            count = Math.min(count, remove);
        }
        return  count;
    }
}
/*
beans = [4,1,6,5]
1) decide and pick which elem will be the minimm for all non-empty bags
2) we can sort the array and try each elem one by one to find optimize result
3) if we select A[i] as the number of beans in non-empty bags, the total number of removels is:
   Total[A] - (N-i) * A[i]

   for all A[k] (k < i), they are completely removed, so the sum to remove is : A[0]+A[1]+...+A[i-1]
   for all A[k] (k >= i), they all become A[i], so the sum to remove is : A[i] + A[i+1] + .... + A[N-1] + (N-i)*A[i]

   After sum of both we get : Total[A] - (N-i)*A[i]

*/
       
