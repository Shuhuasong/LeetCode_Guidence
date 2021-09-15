package Bitwise.Easy.Medium;

/**
 * Created by Shuhua Song
 */
public class _137_SingleNumberII {

    public int singleNumber(int[] nums) {
        int seen_once = 0, seen_twice = 0;
        for(int x : nums){
            seen_once = ~seen_twice & (seen_once ^ x);
            seen_twice = ~seen_once & (seen_twice ^ x);
        }
        return seen_once;
    }
}

/*
Because: x ^ 0 = x, x ^ x = 0

Bitmap  0 0 0 0
 x      0 0 1 0

Bitmap^x:    0 0 1 0
Bitmap^x^x:  0 0 0 0
Bitmap^x^x^x 0 0 0 0

how to detect a number appear one time or three times?
to distinguish between these two situations.

AND and NOT

To separate number that appears once from a number that appears three times let's
use two bitmasks instead of one: seen_once and seen_twice.

The idea is to

change seen_once only if seen_twice is unchanged
change seen_twice only if seen_once is unchanged
e.g.
    seen_once = ~seen_twice & (seen_once^x)
    seen_twice = ~seen_twice & (seen_twice^x)
*/
