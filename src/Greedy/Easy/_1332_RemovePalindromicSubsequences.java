package Greedy.Easy;

/**
 * Created by Shuhua Song
 */
public class _1332_RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if(isPalindrom(s)) return 1;
        return 2;
    }

    private boolean isPalindrom(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

/*
Solution:
1) since the string only have 'a' and 'b' character
2)  a a b b a b a a b
    _ _     _   _ _     aaaaa combine a palindrom
                        bbbb  become a palindrom
3) one corner case: check if the s is palindrome
   if it is==> return 1
       otherwise return 2
 */
