package RollingHash;

/**
 * Created by Shuhua Song
 */
public class _2156_FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length(), start = 0;
        long curr = 0, bigPow = 1;
        // power of k
        for(int i=0; i<k; i++){
            bigPow = bigPow * power % modulo;
        }
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            curr = (c-'a' + 1 + curr * power) % modulo;
            if(i<n-k){ // the window has more than k character, we need move last one char and add one
                curr = (curr-(s.charAt(i+k)-'a'+1) * bigPow % modulo + modulo) % modulo;
            }
            if(i<=n-k && curr==hashValue){
                start = i;
            }
        }
        return s.substring(start, start+k);
    }
}

/*
hash(s, p, m) = (val(s[0] * p0 + val(s[1]) * p1) + ... + val(s[k-1]) * pk-1) mod m
k = 3
XXXXbcxXXXX---> XXXabcdXXXX---> XXXabcXXXXX
add 'a' to the left   hash(s,10, 10) ---> "bcd" = 432%10
sub 'd' to the right  hash(s, 10, 10)---> "abcd" = (1 + (432)*10)%10 = 4321
                      hash(s, 10, 10)---> "abc" = ((1 + (432)*10)%10 - 4*10^3%10) = (4321-4000)%10
Time complexity O(n)



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
