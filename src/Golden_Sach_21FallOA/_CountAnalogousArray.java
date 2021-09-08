package Golden_Sach_21FallOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
An array is said to be analogous to the secret array if all of the following conditions are true:
• The length of the array is equal to the length of the secret array.
• Each integer in the array lies in the interval [lowerBound, upperBound].
• The difference between each pair of consecutive integers of the array must be equal to the difference between the respective pair of consecutive integers in the secret array. In other words, let the secret array be [s[0], s[1],..., s[n-1]] and let the analogous array be [a[0], a[1],..., a[n-1]], then (a[i-1] - a[i]) must be equal to (s[i-1] - s[i]) for each i from 1 to n -1.

Given the value of integers lowerBound and upperBound, inclusive, and the array of differences between each pair of consecutive integers of the secret array, find the number of arrays that are analogous to the secret array. If there is no array analogous to the secret array, return 0.

For example:
consecutiveDifference = [-2, -1, -2, 5]
lowerBound = 3
upperBound = 10

Note that none of the values is out of the bound. All possible analogous arrays are:
[3, 5, 6, 8, 3]
[4, 6, 7, 9, 4]
[5, 7, 8, 10, 5]

Tha answer is 3.
 */
public class _CountAnalogousArray {

   /* private static int countAnalogousArray(List<Integer> consecutiveDifference, int lowerBound, int upperBound){

        int count = 0, n = consecutiveDifference.size();
        int[] nums = new int[n+1];
        boolean isValid = true;
         for(int start=lowerBound; start<=upperBound; start++){
             nums[0] = start;
             for(int i=1; i<=n; i++){
                 int currNum = nums[i-1]-consecutiveDifference.get(i-1);
                 if(currNum < lowerBound || currNum > upperBound) {
                     isValid = false;
                     break;
                 }else{
                     nums[i] = currNum;
                 }
             }
             count += (isValid ? 1 : 0);
         }
         return count;
    } */

    private static int countAnalogousArray(List<Integer> consecutiveDifference, int lowerBound, int upperBound){
        int count = 0, n = consecutiveDifference.size();
        int minVal = lowerBound, maxVal = lowerBound;
        int prevNum = lowerBound, currNum = 0;
        for(int i=1; i<=n; i++){
            currNum = prevNum - consecutiveDifference.get(i-1);
            minVal = Math.min(minVal, currNum);
            maxVal = Math.max(maxVal, currNum);
            prevNum = currNum;
        }

        while(maxVal <= upperBound){
            if(minVal >= lowerBound){
                count++;
            }
            minVal += 1;
            maxVal += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] diff = {-2, -1, -2, 5};
        List<Integer> list = new ArrayList<>();
        for(int a : diff) list.add(a);
        int lowBound = 3, upperBound = 10;
        System.out.println(countAnalogousArray( list , 3, 10));
    }
}
