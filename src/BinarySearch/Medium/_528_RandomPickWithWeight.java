package BinarySearch.Medium;

import java.util.Random;

/**
 * Created by Shuhua Song
 */
public class _528_RandomPickWithWeight {

    Random rand = new Random();
    int total = 0;
    int[] preSum;
    public _528_RandomPickWithWeight(int[] w) {
        int n = w.length;
        preSum = new int[n];
        preSum[0] = w[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + w[i];
        }
        total = preSum[n-1];
    }


    public int pickIndex() {
        int weight = rand.nextInt(total)+1;
        System.out.println("w = " + weight);
        int left = 0, right = preSum.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(preSum[mid]==weight) return mid;
            else if(preSum[mid] < weight){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
