package Golden_Sach_21FallOA;

import java.util.function.Function;

/**
 * Created by Shuhua Song
 */
public class GroupingDigits {
/*
    Given an array of binary digits, 0 and 1, sort the array so that all zeros are at one end and all ones are at the other.
    Which end does not matter. To sort the array, swap any two adjacent elements. Determine the minimum number of swaps to
    sort the array.

    Example
    arr = [0, 1, 0, 1]
    With 1 move, switching elements 1 and 2 yields [0, 0, 1, 1], a sorted array

    Function Description
    Complete the function minMoves

    minMoves has the following parameter(s):
    int arr[n]: an array of binary digits

            Returns
    int: the minimum number of moves necessarry

    Constraints

1 <= n <= 10^5
    arr[i] is in the set {0, 1}
    Another Example
    arr = [1, 1, 1, 1, 0, 0, 0 0]
    We return 0 because we do not need to swap any elements
 */
    private static int minMove(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int n = arr.length;
        int[] preZero = new int[n+1];
        int[] preOne = new int[n+1];
        for(int i=0; i<n; i++){
            preZero[i+1] = preZero[i] + (arr[i]==0 ? 1 : 0);
            preOne[i+1] = preOne[i] + (arr[i]==1 ? 1 : 0);
        }
        int moveOne = 0, moveZero = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                moveOne += preZero[i+1];
            }
            if(arr[i]==0){
                moveZero += preOne[i+1];
            }
        }
        System.out.println(moveZero + " " + moveOne);
        return Math.min(moveZero, moveOne);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 0};
        System.out.println(minMove(nums));
    }
}
/*
nums = {0, 1, 0, 1}--> 1
nums = {1,1,1,1,0,1,0,1}-->3
 */