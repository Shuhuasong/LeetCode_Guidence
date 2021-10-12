package Bitwise;

/**
 * Created by Shuhua Song
 */
public class _201_BitwiseANDofNumberRange {

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
            left >>=1;
            right >>=1;
            shift++;
        }
        return left << shift;
    }
    /*
     public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
           right = right & (right-1);
        }
        return left & right;
    }
     */
}


/*
Solution 1 : Bit Shift
 reformulate the problem as "given two integer numbers, we are asked to find the common prefix of their binary strings."
for example:
 m = 9 = 0 0 0 0 1 0 0 1
 n = 12= 0 0 0 0 1 1 0 0
 After shift right 3 bit == > both are equal
       0 0 0 0 1
 then we shift left 3 bit back to return the common prefix


 Solution 2: Brian Kernighan's Algorithm
 he idea is that for a given range [m, n] (i.e. m<n), we could iteratively apply the trick on the number nn to turn off its rightmost bit of one until it becomes less or equal than the beginning of the range (m), which we denote as n'. Finally, we do AND operation between n' and m to obtain the final result.
for example:
 m = 9 = 0 0 0 0 1 0 0 1
 n = 12= 0 0 0 0 1 1 0 0
 turn off rightmost 1-bits of n one by one, stop when m >= n
 step 1:
  m = 9 = 0 0 0 0 1 0 0 1
 n = 1 2= 0 0 0 0 1 0 0 0
                    _

 */
