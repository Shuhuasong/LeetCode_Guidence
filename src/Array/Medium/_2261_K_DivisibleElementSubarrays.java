package Array.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _2261_K_DivisibleElementSubarrays {

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> seen = new HashSet<>();
        for(int i=0; i<n; i++){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<n; j++){
                sb.append(nums[j]+",");
                if(nums[j]%p==0){
                    count++;
                }
                if(count > k) break;
                seen.add(sb.toString());
            }
        }
        return seen.size();
    }
}
