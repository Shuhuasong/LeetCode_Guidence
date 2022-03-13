package BinarySearch.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1552_MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        //min force, max force
        int n = position.length;
        int left = 0, right = position[n-1];
        int res = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(valid(position, mid, m)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            //System.out.println(left + " " + right);
        }
        return res;
    }
    //check if we can put all m balls when two balls's force is always greater than or equal to max
    private boolean valid(int[] pos, int subForce, int m){
        int count = 1;
        int prev = pos[0];
        for(int i=0; i<pos.length; i++){
            if(pos[i]-prev>= subForce){
                count++;
                prev = pos[i];
                //if(count > m) return false;
            }
        }
        return count>=m;
    }
}
