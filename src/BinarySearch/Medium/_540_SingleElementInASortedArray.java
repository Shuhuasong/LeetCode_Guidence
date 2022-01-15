package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _540_SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length-1;
        int n = nums.length;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            //if sufHalfEven%2==0, then with odd length
            boolean sufHalfEven= (hi-mid)%2==0;
            if(nums[mid]==nums[mid+1]){
                if(sufHalfEven){
                    lo = mid + 2;
                }else{
                    hi = mid - 1;
                }
            }else if(nums[mid]==nums[mid-1]){
                if(sufHalfEven){ //
                    hi = mid - 2;
                }else{
                    lo = mid + 1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[lo];
    }
}

/*
The key observation to make is that the starting array must always have an odd number of elements (be odd-lengthed), because it has one element appearing once, and all the other elements appearing twice.

nums :
case 1: mid's parter is on the right, and the pref halves were even
the right side has odd-length, so we need set lo = mid + 2
        mid(5)   new lo(6)
|left subAry|      |right subarray|
 1  1  4  4  5  5  6  8  8
             _  _

case 2: mid's parter is on the right, and the pref halves were odd
the left side has odd-length, so we need set hi = mid - 1
          new hi
|left subAry|      |right subarray|
 1  1  4  5  5  6  6  8  8  9  9
                _  _

case 3: mid's parter is on the left, and the pref halves were odd
the left side has odd-length, so we need set hi = mid - 2
  new hi    mid
|left subAry|      |right subarray|
 1  1  4  5  5  6  6  8  8
          _  _

case 4: mid's parter is on the left, and the pref halves were even
the right side has odd-length, so we need set lo = mid + 1
               mid new lo
|left subAry|      |right subarray|
 1  1  4  4  5  5  6  6  8  9  9
             _  _

*/
