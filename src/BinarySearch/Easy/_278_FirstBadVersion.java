package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _278_FirstBadVersion {


    boolean isBadVersion(int version){
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right-left)/2;
            //if the current position is bad version,
            //we need move to left side to find earlier bad version
            if(isBadVersion(mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //right,left
        return left;
    }

    /*
    public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                //the mid position may be the answer, so don't escape
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(isBadVersion(left)) return left;
        return right;
    }
}
     */
}
