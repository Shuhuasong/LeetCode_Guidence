package BinarySearch.Medium;

import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1428_LeftMostColumnWithAtLeastAOne {

    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
  };

    //Two Pointer
    //Time = O(m+n)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0), cols = list.get(1);
        int res = cols;
        int x = 0, y = cols-1;
        while(x<rows && y>=0){
            int val = binaryMatrix.get(x, y);
            if(val==0) x++;
            else{
                res = y;
                y--;
            }
        }
        return res==cols ? -1 : res;
    }


    //Binary Search
    //Time = O(n*logm)
 /*   public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0), cols = list.get(1);
        int res = cols;
        for(int i=0; i<rows; i++){
            int left = 0, right = cols-1;
            while(left <= right){
                int mid = left+(right-left)/2;
                if(binaryMatrix.get(i, mid)==1){
                    res = Math.min(res, mid);
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return res==cols ? -1 : res;
    } */
}

/*
1. (Binary Search) For each row do a binary search to find the
leftmost one on that row and update the answer.
2. (Optimal Approach) Imagine there is a pointer p(x, y) starting
from top right corner. p can only move left or down. If the value
at p is 0, move down. If the value at p is 1, move left. Try to
figure out the correctness and time complexity of this algorithm.

 */
