package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        int n = nums.length;
        if(n==0) return results;
        int l = -1;
        for(int r=0; r<n; r++){
            l = r;
            while(r+1<n && nums[r]+1==nums[r+1]){
                r++;
            }
            if(nums[l]==nums[r]){
                results.add(nums[l]+"");
            }else{
                results.add(nums[l]+"->"+nums[r]);
            }
        }
        return results;
    }

    /*
     public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        int n = nums.length;
        if(n==0) return results;
        int l = 0;
        for(int r=0; r<n && l<n; r++){
            if(r+1<n && nums[r]+1==nums[r+1]){
                continue;
            }
            if(nums[l]==nums[r]){
                results.add(nums[l]+"");
            }else{
                results.add(nums[l]+"->"+nums[r]);
            }
            l = r+1;
        }
        return results;
    }
     */
}
