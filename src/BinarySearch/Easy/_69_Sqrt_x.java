package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _69_Sqrt_x {
    //Time = O(logx), Space = O(1)
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = x/2;
        long sum = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            //mid*mid may out of range of Integer,
            //so convert the value to long
            sum = (long)mid*mid;
            if(sum==x) return mid;
            else if(sum < x) left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
