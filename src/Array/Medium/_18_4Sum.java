package Array.Medium;

import java.util.*;

public class _18_4Sum {

    //Two Pointer: Time = O(n^3)  space = O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                twoSumII(nums,i, j, target-nums[i]-nums[j], results);
            }
        }
        return results;
    }


    private void twoSumII(int[] nums,int i, int j, int sum, List<List<Integer>> results){
        int left = j+1, right = nums.length-1;
        while(left < right){
            if(nums[left]+nums[right] < sum){
                left++;
            }else if(nums[left]+nums[right] > sum){
                right--;
            }else{
                results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                while(left < right && nums[left] == nums[left+1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right-1]){
                    right--;
                }
                left++;
                right--;
            }
        }
    }

  /*  public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(nums==null || nums.length==0) return results;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = 0;
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                left = j+1; right = n-1;
                int sum = target - (nums[i]+nums[j]);
                while(left < right){
                    if(nums[left]+nums[right] < sum){
                        left++;
                    }else if(nums[left]+nums[right] > sum){
                        right--;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        System.out.println(nums[i] + " " + nums[j] + " " +nums[left] + " " +nums[right]);
                        //Collections.sort(list);
                        if(!set.contains(list)){
                            set.add(list);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        for(List<Integer> curList : set){
            results.add(curList);
        }
        return results;
    }

   */
}
