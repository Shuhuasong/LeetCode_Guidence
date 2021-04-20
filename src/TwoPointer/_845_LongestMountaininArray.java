package TwoPointer;

public class _845_LongestMountaininArray {
    //Time = O(n) Space = O(1)
    public int longestMountain(int[] A) {
        if(A==null || A.length<3) return 0;
        int base = 0, end = 0, n = A.length;
        int res = 0;
        while(base < n){
            end = base;
            //if base is a left-boundary
            if(end+1 < n && A[end] < A[end+1]){
                //set end forward to peek of this potenial mountain
                while(end+1<n && A[end] < A[end+1]) end++;
                //if this end is really a peak
                if(end+1 < n && A[end] > A[end+1]){
                    // set end to the right-boundary of mountain
                    while(end+1 < n && A[end] > A[end+1]) end++;
                    res = Math.max(res, end-base+1);
                }
            }
            base = Math.max(end, base+1);
        }
        return res;
    }
}

/*
we need to find rise subarray first, and then down subarray;
if mountain existed, the next possible mountain will start at base=end; if it didn't exist, then we may reach the end, or we start from base+1 when the subarray is down, have A[base] >= A[base+1]
*/
