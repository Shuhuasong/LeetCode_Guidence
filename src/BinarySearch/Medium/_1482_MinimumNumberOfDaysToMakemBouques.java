package BinarySearch.Medium;

public class _1482_MinimumNumberOfDaysToMakemBouques {

    /*
    if(m*k>n), it is impossible, return -1;
    otherwise, make binary search the result
    start = 1, is the smallest day,
    end = 1e9 is surely big enough to get m bouquests
    so we binary search in range [start, end]

    Given mid days, we can know which flowers must bloom at mid day, when bloomDay[i] <= mid
    Now the problem is, given an array of true and false,
    find out how many adjacent true bouquest in total

    if bouq < m, mid is too small, so left = mid + 1;
    if bouq > m, mid is too large, so right = mid -1;
     */

    //Time = O(n log (maxA))
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;

        int start = 1, end = (int)1e9;
        while(start<=end){
            int mid = start+(end-start)/2;
            int sumBouq = getSumBoq(bloomDay, mid, m,  k);
            if(sumBouq >= m){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    private int getSumBoq(int[] bloomDay, int day,  int m, int k){
        int n = bloomDay.length, sum = 0, sumBoq = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i]<=day){
                sum++;
                if(sum==k){
                    sumBoq++;
                    sum = 0;
                }
            }else{
                sum = 0;
            }
        }
        return sumBoq;
    }

}
