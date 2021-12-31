package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _1870_MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = (int)1e9;
        int res = -1, n = dist.length;
        while(left <= right){
            int mid = left + (right-left)/2; //mid = speed
            double sum = 0;
            for(int i=0; i<n-1; i++){
                if(((double)dist[i])%mid!=0){
                    sum += (dist[i])/mid + 1;
                }else{
                    sum += ((double)dist[i])/mid;
                }
                //sum += Math.ceil(((double)dist[i])/mid);
            }
            //The last train don't need to convert to integer
            sum += ((double)dist[n-1])/mid;
            //System.out.println(left + " " + right + " " + sum + " " + hour);
            if(sum==hour) return mid;
            else if(sum <= hour){ //spend too less hours == > reduce speed
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1; // increase sppeed
            }

        }
        return res;
    }
}

/*
 java.lang.Math.ceil(double a) returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.
 Math.ceil(12.4) = 13

 */
