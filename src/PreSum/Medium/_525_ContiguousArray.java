package PreSum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _525_ContiguousArray {
    //Time = O(n), Space = O(n)
    public int findMaxLength(int[] nums) {
        int maxLen =  0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(count, -1);
        for(int i=0; i<nums.length; i++){
            count += nums[i]==0 ? -1 : 1;
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLen;
    }

    /*
    //Time = O(n^2), TLE
     public int findMaxLength(int[] nums) {
        int maxLen =  0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int zero = 0, one = 0;
            for(int j=i; j<n; j++){
                if(nums[j]==0) zero++;
                else
                    one++;
                if(zero==one)
                 maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
     */
}

/*
Intuitive:
nums = {0, 1, 0, 0, 1, 1, 0}
2
1
0         \  / \         / \
-1         \/   \       /   \
-2               \    /
                  \  /

 map:
count index
  0     -1
  -1     0
  -2     3
index = 0, count -= 1 ==> count = -1
index = 1, count += 1===> count = 0 ==> len = 1-(-1) = 2
index = 2, count -= 1===> count = -1 ==> len = 2-0 = 2
index = 3, count -= 1===> count = -2
index = 4, count +=1 ==> count = -1 ===> len = 4-0 = 4
index = 5, count +=1 ==> count = 0  ===> len = 5=(-1) = 6
index = 6, count -= 1 ===> count = -1 ===> len = 6-0 = 6
maxLen = 6
*/

