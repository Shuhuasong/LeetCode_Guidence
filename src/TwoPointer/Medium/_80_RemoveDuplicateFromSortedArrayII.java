package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _80_RemoveDuplicateFromSortedArrayII {
    //Time = O(n)
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int l = 1;
        for(int r=0; r<n; r++){
            if(r==0 || r==1) continue;
            if(nums[r]==nums[l] && nums[r]==nums[l-1]){
                continue;
            }else{
                l++;
                nums[l] = nums[r];
            }
        }
        return l+1;
    }

    /*
     //Time = O(n)
    public int removeDuplicates(int[] nums) {
       int n = nums.length;
       if(n==0) return 0;
       if(n==1) return 1;
       int l = 1, count = 1;
       for(int r=1; r<n; r++){
           if(nums[r]==nums[r-1]){
               count++;
           }else{
               count = 1;
           }
           if(count <= 2){
               nums[l] = nums[r];
               l++;
           }
       }
        return l;
    }
     */
}

/*
  Method-1:
  nums = [0,0,1,1,1,1,2,3,3]
  To do the inplace replacement, we need use slow and faster pointer;
  we compare the nums[right] and nums[left] && nums[left-1]
  Once find the right's pointer element is valid, we will copy it on the left pointeer
  Note: the left = 1, right = 2 at start
  The condition are:
  1) if(nums[right]==nums[left] && nums[right]==nums[left-1])
        right++;
     else{
         left++;
         nums[left] = nums[right];
         right++;
     }

  Method-2:
  at begin: set : l = r = 1
  we compare the nums[right] and nums[right-1]
  and use a count to record the duplicate number we have;
  if both equal: we count++; else--> count = 1

  if count <= 2 is valid, we make a copy:
  {
      nums[left] = nums[right];
      left++;
  }

  if(count > 2), we do nothing, and move the right pointer forward
*/