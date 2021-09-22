package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _315_CountOfSmallerNumberAfterSelf {
    class Pair{
        int val;
        int index;
        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++){
            pairs[i] = new Pair(nums[i], i);
        }
        int[] count = new int[n];
        mergeSort(pairs, 0, n-1, count);
        List<Integer> results = new ArrayList<>();
        for(int c : count){
            results.add(c);
        }
        return results;
    }

    private void mergeSort(Pair[] pairs, int start, int end, int[] count){
        if(start >= end) return;
        int mid = start + (end-start)/2;
        mergeSort(pairs, start, mid, count);
        mergeSort(pairs, mid+1, end, count);
        merge(pairs, start, mid, mid+1, end, count);
    }

    private void merge(Pair[] pairs, int lo, int loEnd, int hi, int hiEnd, int[] count){
        int len = hiEnd-lo+1;
        Pair[] sorted = new Pair[len];
        int loPtr = lo, hiPtr = hi;
        int smallNum = 0, k = 0;
        while(loPtr <= loEnd && hiPtr <= hiEnd){
            if(pairs[loPtr].val > pairs[hiPtr].val){
                smallNum++;
                sorted[k++] = pairs[hiPtr++];
            }else{
                count[pairs[loPtr].index] += smallNum;
                sorted[k++] = pairs[loPtr++];
            }
        }
        while(loPtr <= loEnd){
            count[pairs[loPtr].index] += smallNum;
            sorted[k++] = pairs[loPtr++];
        }
        while(hiPtr <= hiEnd){
            sorted[k++] = pairs[hiPtr++];
        }
        System.arraycopy(sorted, 0, pairs, lo, len);
    }
}
