package Bitwise;

public class _ConcatenationConsecutiveBinaryNum {
    public int concatenatedBinary(int n) {
        final  int MOD = (int)1e9+7;
        int len = 0; //bit length of addends
        long result = 0;
        for(int i=1; i<=n; i++){
            if((i & (i-1))==0){
                len++;
            }
            result = ((result << len) | i) % MOD;
        }
        return (int)result;
    }
}
/*
If (x & (x-1)) == 0, then x is the power of 2.
14 = (00001110)
14 << 1 ===> 00011100 shift one bit left
14 << 2 ===> 00111000 shift two bit left

Update result to (result << length) | i.

conver decimal number to binary string:
String binary = Integer.toBinaryString(num);
 */