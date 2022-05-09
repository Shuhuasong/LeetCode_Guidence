package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _702_SeachInASortedArrayOfUnknonSize {

    interface ArrayReader {
      public int get(int index);
    }

    /*
   Time = O(logn)
   1) use 2 time extend to find the left & right bound
   2) then use binary search to find target
   */
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target) return 0;
        int left = 0, right = 1; //must start from 1 (2*0=0)
        int val = reader.get(right);
        while(val < target){
            left = right;
            right = 2 * right;
            val = reader.get(right);
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            int num = reader.get(mid);
            if(num==target) return mid;
            else if(num<target) left = mid + 1;
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
