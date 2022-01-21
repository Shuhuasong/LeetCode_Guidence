package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        int n = s.length();
        int lo = 0, hi = n-1, diff = 0;
        while(lo <= hi){
            while(lo < hi && s.charAt(lo)==s.charAt(hi)){
                lo++;
                hi--;
            }
            if(lo==hi) return true;
            if(lo < hi){
                //case 1: remove the character on the left
                //case 2: remove the character on the right
                return isPalin(s.substring(lo+1, hi+1)) || isPalin(s.substring(lo, hi));
            }
        }
        return true;
    }

    private boolean isPalin(String s) {
        if (s.length() == 0) return true;
        int lo = 0, hi = s.length() - 1;
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}

//"abcseefeesca"
/*
"abc"

lo = 0, hi = 2

 */

