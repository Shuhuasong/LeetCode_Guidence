package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _287_FindTheDuplicateNumber {
    //Approach#3: Floyd's Tortoise and Hare(Cycle Detection)
    //Time = O(n), Space = O(1)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0], fast = nums[0];
        while(true){
            //if(fast == n) break;
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


/*
    //Approach#2: Binary Search
    //Time = O(nlogn), Space = O(1)
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;
        int res = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int count = 0;
            for(int num : nums){
                if(num <= mid) count++;
            }
            //The count is greater than the actaual correct number order
            //we need t0 move right to find smallest number
            if(count > mid){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

 */

    /*
    //Approach#1: Arrays as HashMap
    //Time = O(n), Space = O(1)
    public int findDuplicate(int[] nums) {
        //replace the number at position 0 and nums[0]
        while(nums[0] != nums[nums[0]]){
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    } */
}
