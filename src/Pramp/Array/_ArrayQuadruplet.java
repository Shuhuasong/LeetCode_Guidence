package Pramp.Array;

import java.util.Arrays;

public class _ArrayQuadruplet {

    /*
    Array Quadruplet
Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.

Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).

Explain and code the most efficient solution possible, and analyze its time and space complexities.

Example:

input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20

output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                     # whose sum is 20. Notice that there
                     # are two other quadruplets whose sum is 20:
                     # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                     # asked to return the just one quadruplet (in an
                     # ascending order)
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer s

[output] array.integer
     */

    static int[] findArrayQuadruplet(int[] arr, int s){
        // your code goes here
        if(arr.length < 4) return new int[]{};
        int n = arr.length;
        int[] res = new int[4];
        Arrays.sort(arr);
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                int lo = j+1, hi = n-1;
                while(lo + 1 < hi){
                    int mid = lo + (hi - lo)/2;
                    int total = arr[i]+arr[j]+arr[lo]+arr[hi];
                    if(total > s){
                        hi = mid;
                    }else if(total < s){
                        lo = mid;
                    }else{
                        res[0] = arr[i]; res[1] = arr[j];
                        res[2] = arr[lo]; res[3] = arr[hi];
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 4, 0, 9, 5, 1, 3};
        int s = 20;
        int[] result = findArrayQuadruplet(nums, s);
        for(int a : result){
            System.out.print(a + " ");
        }
    }

}
