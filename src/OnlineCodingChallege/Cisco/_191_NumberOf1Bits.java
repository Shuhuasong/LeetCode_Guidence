package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _191_NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            int bit = 1 & n;
            if(bit==1) count++;
            n = n>>1;
        }
        return count;
    }
}
