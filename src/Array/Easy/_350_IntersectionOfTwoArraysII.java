package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _350_IntersectionOfTwoArraysII {

    //Time = O(m+n) Space = O(min(m, n))
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num, 0);
            if(count > 0){
                nums1[k++] = num;
                map.put(num, count-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    //Sort
    //Time: O(nlogn + mlogm)
 /*   public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, k=0;
        int m = nums1.length, n = nums2.length;
        List<Integer> list =new ArrayList<>();

        while(i<m && j<n){
            if(nums1[i]< nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] results = new int[list.size()];

        for(int a : list){
            results[k++] = a;
        }
        return results;
    }

  */

}

/*
The Questions for the interview:
1) how should I handle duplicates?
2)  the order of inputs and outputs
Approach 1 : Hash Map
Approach 2 : Sort + Two Pointer
Approach 3 : Built-in Intersection
   Java : Use retainOccurrences
   C++  : set_intersection

Follow-up Questions
What if the given array is already sorted? How would you optimize your algorithm?

We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.
What if nums1's size is small compared to nums2's size? Which algorithm is better?

Approach 1 is a good choice here as we use a hash map for the smaller array.
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.

If neither of the arrays fit into the memory, we can apply some partial processing strategies:

Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.

 */
