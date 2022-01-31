package RollingHash;

/**
 * Created by Shuhua Song
 */
public class _2156_FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        //compute : 96^14 since it is very big
        long bigPower = 1;
        for(int i=1; i<k; i++){
            bigPower = (bigPower * power) % modulo;
        }
        //compute last k character
        long hash = 0;
        for(int i=0; i<k; i++){
            int charVal = s.charAt(n-i-1) - 'a' + 1;
            hash = (hash * power + charVal) % modulo;
        }
        int resIdx = -1;
        if(hash==hashValue){
            resIdx = n-k;
        }

        for(int i=k; n-i-1 >= 0; i++){
            int tailVal = s.charAt(n-i-1+k) - 'a' + 1;
            hash = ((hash-tailVal * bigPower)%modulo+modulo)%modulo;
            int headVal = s.charAt(n-i-1) - 'a' + 1;
            hash = (hash * power + headVal)%modulo;
            if(hash==hashValue){
                resIdx = n-i-1;
            }
        }
        return s.substring(resIdx, resIdx+k);
    }
}

/*
"xmmhdakfursinye"
96
45
15
21
"leetcode"
7
20
2
0

1) compute the rolling hash from the end of string
2) during the process, keep a sliding window of size k from end to begin
3) First, compute the substring hashcode of the last k character,
   then we add one char one the front and drop last char in the window

10^99 mod 113 == 67
(A*B) mod C = ((A mod C) * (B mod C)) mod C
int n = 1;
for(int i=0; i<99; i++){
    n = (n*10)%113;
}
*/
