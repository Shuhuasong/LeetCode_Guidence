package Heap.Medium;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _215_KthLargestElementInAnArray {

    //Time = O(n*logK), Space = O(1)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    /*
     //BinarySearch: Time = O(n*logV)
    public int findKthLargest(int[] nums, int k) {
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int num : nums){
            start = Math.min(num, start);
            end = Math.max(num, end);
        }
        while(start <= end){
            int mid = start + (end-start)/2;
            //the mid is too small, so the count greater
            //we need increase mid
            if(countGreater(nums, mid) >= k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }

    private int countGreater(int[] nums, int mid){
        int count = 0;
        for(int num : nums){
            count += (num > mid ? 1 : 0);
        }
        return count;
    }
     */
}


//Time complexity = O(N+N/2+N/4+...+1) = O(2N-1) = O(N)
//Space = O(1)
//Divide and Conquer

/*    public int findKthLargest(int[] nums, int k) {
        divide(nums, 0, nums.length-1, k);
        return nums[nums.length-k];
    }
    //use divide to find a position wether it is the position of last kth element
    private void divide(int[] nums, int left, int right, int k){
        if(left >= right) return;
        int position = partition(nums, left, right);
        if(position==nums.length-k) return;
        //the position find is smaller than target, then search on right side
        if(position < nums.length-k) divide(nums, position+1, right, k);
        else
            //the position find is greater than target, then search on left side
            divide(nums, left, position-1, k);
    }
    //use last element as pivot, put all elems < pivot on the left of wall,
    //then swich the position of wall and pivot, then pivot is on the right position
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right], wall = left;
        for(int i=left; i<right; i++){
            if(nums[i] < pivot){
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }
    /*
    private int partition(int nums, int left, int right){
        int pivot = nums[right];
        int start = left, end = right-1;
        while(start <= end){
            if(nums[i] < pivot) start++;
            else if(nums[end] > pivot) end--;
            else swap(nums, start++, end--);
        }
        swap(nums, start, right);
        return start;
    } 

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } */

/*
/*
Brute force;
Arrays.sort(nums) ==> get last kth elment

[3,2,3,1,2,4,5,5,6], k = 4

1 2 3 4 5
5 4 3 2 1


/*
Brute force;
Arrays.sort(nums) ==> get last kth elment

[3,2,3,1,2,4,5,5,6], k = 4

1 2 3 4 5
5 4 3 2 1

Divide and conquer Example:

1) partition: left = 0, right = 5
   pivot = nums[5] = 4
    0 1 2 3 4 5
   [3,2,1,5,6,4]
    | | | |   |
         wall right ==> swap wall(3) and right(5) position
         return wall = 3 < target = 6-2 = 4
    0 1 2 3 4 5
    [3,2,1,4,6,5]
2) partition: left = position = wall + 1 = 4, right = 5
     0 1 2 3 4 5
    [3,2,1,4,6,5]   return wall = 4 == target = 6-2 = 4
             | |
          wall right
*/


