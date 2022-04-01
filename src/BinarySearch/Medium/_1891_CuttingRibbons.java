package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _1891_CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int start = 1, end = 0;
        for(int r : ribbons){
            end = Math.max(end, r);
        }
        int res = 0;
        while(start<=end){
            int mid = start+(end-start)/2;
            int numRib = getNum(ribbons, mid);
            if(numRib < k){
                end = mid-1;
            }else{//maximum length
                res = mid;
                start = mid+1;
            }
        }
        return res;
    }

    private int getNum(int[] ribs, int limit){
        int count = 0;
        for(int r : ribs){
            count += r/limit;
        }
        return count;
    }
}
