package Bitwise.Easy;

/**
 * Created by Shuhua Song
 */
public class _190_ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //iterate the bit string from right to left, (n = n >>1)
        //to retrieve the right-most bit of an integer, we apply the
        // bit AND operation
        int ans = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            //left shift 1 bit result andd add LSB bit of n to result
            ans = ans << 1;
            ans = ans | (n&mask);
            //right shift n to 1 bit to discard the bit which is added to result
            n >>= 1;
        }
        return ans;
    }
}
