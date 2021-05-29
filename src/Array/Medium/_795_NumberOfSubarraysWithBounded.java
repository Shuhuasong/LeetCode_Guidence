package Array.Medium;


/*
count(B) is the number of subarrays that have all elements less than or
equal to B. so : count(R) - count(L-1)

 */

public class _795_NumberOfSubarraysWithBounded {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }
    //count # of sub arrays whose max element is <= bound
    private int count(int[] A, int bound){
        int ans = 0, cur = 0;
        for(int a : A){
            if(a <= bound){
                cur = cur + 1;
                ans += cur;
            }else{
                cur = 0;
            }
        }
        return ans;
    }
}
