package BinarySearch.Medium;

public class _34_FindFirstLastElement {

    //Time = O(log n) Space = O(n)

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.

    public int[] searchRange(int[] nums, int target) {
        // if(nums.length < 2) return new int[]{-1, -1};
        int first = findIdx(nums, target, true);
        if(first==-1) return new int[]{-1, -1};
        int second = findIdx(nums, target, false);
        return new int[]{first, second};
    }

    private int findIdx(int[] nums, int target, boolean isLeft){
        int lo = 0, hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                if(isLeft){
                    //This means we found our lower bound
                    if(mid==lo || nums[mid-1] != target){
                        return mid;
                    }
                    //continue find on the left side
                    hi = mid - 1;
                }else{
                    //This means we found our lower bound
                    if(mid==hi || nums[mid+1] != target){
                        return mid;
                    }
                    //continue find on the right side
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    /*
     //Binary Search: O(logn)
    public int[] searchRange(int[] nums, int target) {
      int[] res = new int[2];
      res[0] = -1;
      res[1] = -1;
      if(nums == null|| nums.length==0) return res;
      res[0] = findFirst(nums, target);
      res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) index = mid;
            if(nums[mid] >= target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return index;
    }

     private int findLast(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) index = mid;
            if(nums[mid] <= target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return index;
    }
     */



    //Time = O(n) Space = O(1)
/*    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int[] results = new int[2];
        int min = -1, max = -1;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                min = i;
                break;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(nums[i]==target){
                max = i;
                break;
            }
        }
        return new int[]{min, max};
    }

 */
}
