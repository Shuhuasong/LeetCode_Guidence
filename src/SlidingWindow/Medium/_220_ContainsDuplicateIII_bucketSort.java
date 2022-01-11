package SlidingWindow.Medium;

import java.util.TreeSet;

/**
 * Created by Shuhua Song
 */
public class _220_ContainsDuplicateIII_bucketSort {

    //Time = O(n*log(min(n, k))), Space = O(min(n, k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            Integer succ = set.ceiling(nums[i]);
            if(succ != null && Math.abs((long)succ-nums[i]) <= t) return true;
            Integer pred = set.floor(nums[i]);
            if(pred != null && Math.abs(nums[i]-(long)pred) <= t) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    /*
    //Buckets
    //Time = O(n), Space = O(min(n, k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        int n = nums.length;
        Map<Long, Long> bucket = new HashMap<>();
        long dist = (long)t+1; //the dist for each bucket
        for(int i=0; i<n; i++){
            long buckId = getBuckId(nums[i], dist);
            if(bucket.containsKey(buckId)) return true;
            if(bucket.containsKey(buckId-1) && Math.abs(nums[i]-bucket.get(buckId-1)) < dist)
                return true;
            if(bucket.containsKey(buckId+1) && Math.abs(nums[i]-bucket.get(buckId+1)) < dist)
                return true;
            bucket.put(buckId, (long)nums[i]);
            if(i>=k) bucket.remove(getBuckId(nums[i-k], dist));
        }
        return false;
    }
    //The Id of bucket from element value x and bucket dist
    //in Java, '-3/5=0', but we need '-3/5 = -1'
    private long getBuckId(long x, long dist){
        return (x < 0) ? (x+1)/dist-1 : x/dist;
    }
     */
}

/*
[-2147483648,2147483647]
1
1
[1,2,3,1], k = 3, t = 0
w = 1
  0  1   2  3   4   5  6   7
[20, 13, 4, 49, 41, 32, 9, 18], k = 3, t = 5
bucket number:
    0      1      2     3     4
num 4      13     20    32    49
    9      18                 41

Map:{1:{9}} {5:{32}}  {6:{41}}
w = t+1 = 6
nums[0] = 20, m = 20/6 = 3
nums[1] = 13, m = 13/6 = 2, |13-20|=6 < 6 ?
nums[2] = 4, m = 4/6 = 0
nums[3] = 49, m = 49/6 = 8   nums[i-k] = 20/6 = 3
nums[4] = 41, m = 41/6 = 6,
nums[5] = 32, m = 32/6 = 5, |32-41| = 9 < 6?
nums[6] = 9, m = 9/6 = 1
nums[7] = 18, m = 18/6 = 3


Solution-1: use TreeSet-Binary search Tree
Steps:
1) initialize an empty BST set
2) Loop through the array, for each element x:
   --Find the smallest element s(successor) in Set that is greater than or equal to x, return true if (s-x) <= t
   --Find the greatest element p(predecessor) in Set that is smaller
than or equal to x, return true if (x-p) <= t
   --put x in set when both not exist
   --if the size of the set is larger than k, remove the oldest item
return false;

Time Complexity: O(n*log(min(n, k))). For each iteration in array, it costs O(log(min(k, n))) time (search, insert, or delete) in the BST;
Space Complexity: O(min(n, k)), the size of the BST is upper bounded by both k and n
*/
