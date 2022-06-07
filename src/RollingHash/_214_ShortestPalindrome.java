package RollingHash;

/**
 * Created by Shuhua Song
 */
public class _214_ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if(s.length() < 1) return s;
        long leftHash = 0, rightHash = 0;
        int MOD = (int)1e9+7;
        long power = 1;
        int end = 0, base = 26;
        for(int i=0; i<s.length(); i++){
            leftHash = (leftHash*26 + s.charAt(i)-'0') % MOD;
            rightHash = (rightHash + (s.charAt(i)-'0') * power) % MOD;
            power = (power * base) % MOD;

            if(leftHash==rightHash){
                end = i;
            }
        }
        String rem = s.substring(end+1);
        String revSt = reverse(rem);
        return revSt + s;
    }

    private String reverse(String s){
        int l = 0, r = s.length()-1;
        char[] chs = s.toCharArray();
        while(l < r){
            char tmp = chs[l];
            chs[l] = chs[r];
            chs[r] = tmp;
            l++;
            r--;
        }
        return new String(chs);
    }
}

/*
Solution-1: brute force
e.g: s = abcd, rev= dcba
- get reverse string of s==> rev
- iterate each index i, check if : rev.substring(0, n-i)==s.substring(i)
  e.g: i=1, rev.substring(0, 3)==s.substring(i)==> bcd==bcd
- if rev.substring(0, 3)==s.substring(i)
- then return rev.substring(0, i) + s

Solution-2: rolling hash
e.g   abac --- 1213
assume, we have : base = 26
leftHash = 0, rightHash = 0
              a          ab       aba      abac
left hash     0*26+1   1*26+2   28*26+1    (28*26+1)*26+3
right hash    1+0*26   1+2*26   53+1*26^2  (53+1*26^2) + 3*26^3

abc
left :  a*26^2 + b*26 + c
right   a + b*26 + c*26^2

cba
left: a + b*26 + c*26^2
right: a*26^2 + b*26 + c (calculate reverse: abc)

aba
left: a + b*26 + a*26^2
right: a*26^2 + b*26 + a  (calculate reverse: aba)

 0 1 2 3 4 5 6 7
  "a a c e c a a a"
"a a a c e c a a a"

           "a b c d"
     "d c b a b c d"

*/


