package BinarySearch.Medium;

/*
Given two integers dividend and divisor, divide two integers without using multiplication,
division, and mod operator.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
 */

public class _29_DivideTwoIntegers {
    private static int HALF_INF_MIN = -1073741824;
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if(dividend > 0){
            negative--; //sign == 1
            dividend = -dividend; // 10 --> -10
        }
        if(divisor > 0){ //sign = 0
            negative--;
            divisor = -divisor; // 3 --> -3
        }
        int quotient = 0;
        while(divisor >= dividend){ //-3>-10   -3 > -4
            int powerOfTwo = -1;
            int value = divisor; //value = -3
            while(value >= HALF_INF_MIN && value + value >= dividend){ //-6 > -10
                value += value; //value = -6;
                powerOfTwo += powerOfTwo; //powerOfTwo = -2
            }
            quotient += powerOfTwo; //quotient = -2
            dividend -= value; // dividend =  -4
        }
        if(negative != 1){
            return -quotient;
        }
        return quotient;
    }

    /*
     public int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor==-1){
           return Integer.MAX_VALUE;
        }
        int negatives = 0;
        if(dividend < 0){
            negatives++;
            dividend = -dividend;
        }
        if(divisor < 0){
            negatives++;
            divisor = -divisor;
        }
        int substraction = 0;
        while(dividend - divisor >= 0){
            dividend -= divisor;
            substraction++;
        }
        if(negatives==1){
            substraction = -substraction;
        }
        return substraction;
    }
     */
}




/*
Note:
--the use of long is not allowed, we only have the int range is [-2^31, 2^31-1]
--the use of Math.abs() need to consider out of range when Math.abs(-2^31) > 2^31-1
--alternative for the multiplication, division:
   1) instead of a = a * -1 for making number negative, use a = -a;
   2) instead of using a/2 for dividing by 2, use the right shift operator, a >> 1
   3) instead of using a * 2 for doubling, use a = a + a, a += a, or even left shift operator a << 1
--overflow is not allowed, for some compiler/interpreters/languages,
   INT_MAX + 1 = INT_MIN. for others, INT_MAX + 1 = INT_MAX, others can be undefined or crash
   in Java,  Integer.MAX_VALUE + 1 = Integer.MIN_VALUE  = -2147483648
             Integer.MIN_VALUE – 1 = Integer.MAX_VALUE  = 2147483647

Solution-1: use substraction (Linear Search is too slow) TLE
           The result of dividing the dividend by the divisor is the number of times we could subtract
           the divisor from the dividend. A commonly used name for this result is the quotient.
            public int divide(int dividend, int divisor){
                    int quotient = 0;
                    while(dividend - divisor >= 0){
                        quotient++;
                        dividend -= divisor;
                    }
                    return quotient;
                }

          // handled the -2147483648 / -1 case.
              if (dividend == -2147483648 && divisor == -1) {
                        return 2147483647;
                  }

        --we're converting the inputs to negative numbers. This is because we don't want separate code for all the possible
          combinations of positive/negative divisor and dividend. We converted them to negative instead of positive because
          the range of valid negative numbers is bigger, and therefore overflows can be cleanly avoided.

 */