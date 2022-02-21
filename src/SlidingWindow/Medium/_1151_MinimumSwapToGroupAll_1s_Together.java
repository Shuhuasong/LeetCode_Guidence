package SlidingWindow.Medium;

/**
 * Created by Shuhua Song
 */
public class _1151_MinimumSwapToGroupAll_1s_Together {
    public int minSwaps(int[] data) {
        int numOnes = 0;
        for(int d : data){
            if(d==1) numOnes++;
        }
        if(numOnes <= 1) return 0;
        int l=0, count = 0;
        int res = Integer.MAX_VALUE;
        for(int r=0; r<data.length; r++){
            if(data[r]==1) count++;
            if(r-l+1==numOnes){
                res = Math.min(res, numOnes-count);
            }
            while(r-l+1 >= numOnes){
                if(data[l]==1) count--;
                l++;
            }
        }
        return res;
    }
}
