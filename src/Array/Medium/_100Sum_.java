package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _100Sum_ {
/*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        return dfs(nums,target,4,0);

    }
    public List<List<Integer>> dfs(int[]nums,int target,int k,int index) {//nums,target=10,k=2,index=2
        List<List<Integer>> list = new ArrayList<>();

        if (k == 2) {
            int left = index;
            int right = nums.length - 1;
            while (left < right) {
                List<Integer> l1 = new ArrayList<>();
                if (nums[left] + nums[right] == target) {
                    l1.add(nums[left]);
                    l1.add(nums[right]);
                    list.add(l1);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;

                } else if (nums[left] + nums[right] < target) left++;
                else right--;

            }
        } else {
            for (int i = index; i < nums.length - k + 1; i++) {
                List<List<Integer>> n1 = dfs(nums, target - nums[i], k - 1, i + 1);
                n1:
                2 sum
                if (!n1.isEmpty()) {
                    for (List<Integer> n2 : n1) {  [[1, -1, 1, 2],[1, -1, 2, 1]]
                        n2.add(0, nums[i]);//[-1,1,2] [-1,...],[-1,...] k=4
                    }
                    list.addAll(n1);//
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return list;
    }
    */
}

/*

// k==2, k==3

    Input: nums = [1,0,-1,0,-2,2], target = 0

    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

            3 sums
2 sums

 */
