package RollingHash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1461_CheckIfAStringContainsAllBinaryCodesOfSize_K {

    //Time = o(n)
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] seen = new boolean[need];
        int allOne = need-1;
        int hashcode = 0;
        for(int i=0; i<s.length(); i++){
            //calculate hash value for substring s.substring(i-k+1, i+1)
            hashcode = ((hashcode << 1) & allOne) | (s.charAt(i)-'0');
            //hash only available when the substring len is k (i-k+1 > 0)
            if(i>=k-1 && !seen[hashcode]){
                seen[hashcode] = true;
                need--;
                if(need==0){
                    return true;
                }
            }
        }
        return false;
    }


    /*

    //Time = o(n*k)
    public boolean hasAllCodes(String s, int k) {
        Set<String> codeList = new HashSet<>();
        int need = 1 << k;

        for(int i=k; i<=s.length(); i++){
            String sub = s.substring(i-k, i);
            if(!codeList.contains(sub)){
                codeList.add(sub);
                need--;
                if(need==0){
                    return true;
                }
            }
        }
        return false;
    }

     */
}


/*
Solution-1: Set
1) take substring from s with length k, if it
   is not in set, add it into set. At the same
   time, decrease need, when need = 0, it means
   we find all 2^k number of the needed substring
   eg. k = 2, with string 00, 01, 10, 11

Solution-2: Rolling Hash
1) since we have at most 2^k string, so we can map
   each string to a number in [0, 2^k-1]
2) we have binary number <===> decimal
   we take this decimal as the hash value.
   minimum = 0, maximum = 2^k-1
3) we not necessary to convert the binary to decimal each time
   we can use rolling hash
   e.g
   s = "1101", k = 3
   hashcode("110") = 4+2=6
   how to get hashcode("101") ?
   1> we shift left for "110" ====> 1100
   2> remove first digit, so do : 1100 & 111 = 100
      the all-one helps us to align the digits
   3> we need to apply the lowest digit of "101", which is 1
      to our hash, and by using  |
      we get 100 | last_digit = 100 | 1 = 101

    new_hash = ((old_hash << 1) && all_one) | last_digit_of_new_hash

    rolling hash : O(1) operation

    */
