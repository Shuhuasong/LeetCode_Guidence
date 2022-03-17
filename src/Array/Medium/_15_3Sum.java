package Array.Medium;

import java.util.*;

public class _15_3Sum {
    //Two Pointer ( Array NEED To Be SORTED!!!)
    //Idea: used the for loop to fix the first number, then used left pointer to fix
    //      the second number, and use right pointer to find the appropriate third number
    //      use set to check the duplicate element
    List<List<Integer>> results;
    public List<List<Integer>> threeSum(int[] nums) {
        results = new ArrayList<>();
        if(nums==null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            twoSum(nums, i,  i+1, n-1);
        }
        return results;
    }
    private void twoSum(int[] nums, int i, int left, int right){
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum==0){
                results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++; right--;
                while(left < right && nums[left]==nums[left-1]) left++;
                while(left < right && nums[right]==nums[right+1]) right--;
            }else if(sum < 0) left++;
            else{
                right--;
            }
        }
    }

    /*
      //Two Pointer: Time = O(n^2)  space:   //Two Pointer: Time = O(n^2)  space: O(logn) - O(n) depending on the implementation of the sorting algorithm.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
           if(i==0 || nums[i-1]!=nums[i]){ //skip the duplicate element
               twoSumII(nums, i, results);
           }
        }
        return results;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> results){
            int  l = i + 1, r = nums.length-1;
            while(l < r){
                if(nums[l] + nums[r] < -nums[i]){
                    l++;
                }else if(nums[l] + nums[r] > -nums[i]){
                    r--;
                }else{
                    List<Integer> curList = new ArrayList<>();
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
          }
     }
     */

    //HashMap: Time = O(n^2)  space = O(n)
/*  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n && nums[i]<=0; i++){ //find first element this is negative fisrt
            if(i==0 || nums[i-1]!=nums[i]){ //skip the duplicate element
                twoSumII(nums, i, results);
            }
        }
        return results;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> results){
        HashSet<Integer> seem = new HashSet<>();
        for(int j=i+1; j<nums.length; j++){
            int comp = -(nums[i]+nums[j]);
            if(seem.contains(comp)){
                results.add(Arrays.asList(nums[i], nums[j], comp));
                while(j+1<nums.length && nums[j]==nums[j+1]){ //skip the duplicate element
                    j++;
                }
            }
            seem.add(nums[j]); //add the second number nums[j], not the comp
        }
    }

   */
}

/*
需要注意的细节：
        0. 一定要先排序。
        2. 为了避免重复，仅在确认发现了一组解之后再移动left和right指针略过重复项。不要先略过重复项再判断是否解成立。
        if (nums[left]+nums[right]==sum)
        {
            记录结果;
            left++;
            right--;
            while (left<right && nums[left]==nums[left-1]) left++;
            while (left<right && nums[right]==nums[right+1]) right--;
        }
        2. 对于最外层的循环，也是确定一个，先展开内层循环，再略过最外层的重复项。
        for (int a=0; a<nums.size(); a++)
        {
           if (a > 0 && nums[a]==nums[a+1]) continue;
            inner loop;
        }
*/
