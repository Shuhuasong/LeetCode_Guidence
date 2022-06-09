package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _1328_BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n<=1) return "";
        char[] chs = palindrome.toCharArray();
        for(int i=0; i<n/2; i++){
            if(chs[i] != 'a'){
                chs[i] = 'a';
                return new String(chs);
            }
        }
        chs[n-1] = 'b';
        return new String(chs);
    }
}

/*
Solution-greedy
1) iterate the half length of string
2) if the character is not 'a'==> change it to 'a'
3) if the character all the way are 'a' ==> change last character to 'b'
*/
