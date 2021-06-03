package BinarySearch.Medium;

public class _29_DivideTwoIntegers {
    private static int HALF_INF_MIN = -1073741824;
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if(dividend > 0){
            negative--;
            dividend = -dividend;
        }
        if(divisor > 0){
            negative--;
            divisor = -divisor;
        }
        int quotient = 0;
        while(divisor >= dividend){
            int powerOfTwo = -1;
            int value = divisor;
            while(value >= HALF_INF_MIN && value + value >= dividend){
                value += value;
                powerOfTwo += powerOfTwo;
            }
            quotient += powerOfTwo;
            dividend -= value;
        }
        if(negative != 1){
            return -quotient;
        }
        return quotient;
    }
}




/*
Note:
--the use of long is not allowed, we only have the int range is [-2^31, 2^31-1]
--the use of Math.abs() need to consider out of range when Math.abs(-2^31) > 2^31-1
--alternative for the multiplication, division:
   1) instead of a = a * -1 for making number negative, use a = -a;
   2) instead of using a/2 for dividing bu 2, use the right shift operator, a >> 1
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