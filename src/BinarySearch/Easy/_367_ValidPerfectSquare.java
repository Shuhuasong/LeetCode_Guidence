package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num<2) return true;
        //square root aa is always less than num/2
        long left = 2, right = num/2;
        while(left <= right){
            long mid = left + (right-left)/2;
            long square = mid*mid;
            if(square==(long)num) return true;
            else if(square < (long)num) left = mid+1;
            else{
                right = mid-1;
            }
        }
        return false;
    }
}
