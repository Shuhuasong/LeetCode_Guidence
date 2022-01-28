package Bitwise.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _421_MaximumXORofTwoNumbersInArray_IIIIIII {

    //Time = (n), Space = O(n)
    public int findMaximumXOR(int[] nums) {
        int maxLen = 0;
        for(int num : nums){
            maxLen = Math.max(maxLen, Integer.toBinaryString(num).length());
        }
        int mask = 0, maxRes = 0;
        for(int L=maxLen-1; L>=0; L--){
            mask = mask | (1<<L);
            Set<Integer> prefix = new HashSet<>();
            for(int num : nums){
                prefix.add(num & mask);
            }

            int temp = maxRes | (1<<L);
            for(int prex : prefix){
                if(prefix.contains(temp ^ prex)){
                    maxRes = temp;
                    break;
                }
            }
        }
        return maxRes;
    }
}

/*

Basic Bit concept:
nums = [3,10,5,25,2,8]
(1) decimal <===> binary

    3  = (00011)
    10 = (01010)
    5  = (00101)
    25 = (11001)
    2  = (00010)
    8  = (01000)
(2) bit shif operation
    e.g   int a = 1; a = a << 4;  a = (10000)2 = 16
(3) bit commutative law
    e.g  5 ^ 25 = 28  ===> 5 ^ 28 = 25
    a ^ b = c  ===> a ^ c = b
    XOR of zero and a bit results in that bit
    0 ⊕ x = x
    XOR of two equal bits (even if they are zeros) results in a zero
    x ⊕ x = 0
(4) compute all possible prefix
    L = 4, mask = 10000
    set = {10000, 00000}

    3  = (0****)      10000  currPrex
    10 = (0****)  XOR 00000  prex in set
    5  = (0****)  ___________
    25 = (1****)      10000  in set
    2  = (0****)
    8  = (0****)  maxRes = 10000
          1****    currPrex
    =======================================
    L = 3, mask = 11000
    set = {00000, 01000, 11000}

    3  = (00***)      11000  currPrex
    10 = (01***)  XOR 00000  prex in set
    5  = (00***)  ___________
    25 = (11***)      11000  in set
    2  = (00***)
    8  = (01***)  maxRes = 11000
          11***    currPrex
    ========================================

    L = 2, mask = 11100
    set = {00000, 01000, 11000, 00100}

    3  = (000**)      11100  currPrex
    10 = (010**)  XOR 00100  prex in set
    5  = (001**)  ___________
    25 = (110**)      11100  in set
    2  = (000**)
    8  = (010**)  maxRes = 11100
          111**    currPrex
    ==========================================

    L = 2, mask = 11100
    set = {00010, 01010, 00100, 11000, 01000}

    3  = (0001*)      11110  currPrex
    10 = (0101*)  XOR 00100  prex in set
    5  = (0010*)  ___________
    25 = (1100*)      11010  XOR each element in set, not exist one pair (a^currPrex=b) in set
    2  = (0001*)
    8  = (0100*)  maxRes = 11100

    ==========================================

    L = 1, mask = 11100
    set = {00011, 01010, 00101, 11001, 00010, 01000}

    3  = (00011)      11111  currPrex
    10 = (01010)  XOR 00101  prex in set
    5  = (00101)  ___________
    25 = (11001)      11010  XOR each element in set, not exist one pair (a^currPrex=b) in set
    2  = (00010)
    8  = (01000)  maxRes = 11100


*/
