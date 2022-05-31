package String.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _564_FindTheCloestPalindrome {

    public String nearestPalindromic(String s) {
        int len = s.length();
        String left = "";
        if(len%2==0){
            left = s.substring(0, len/2);
        }else{
            left = s.substring(0, len/2+1);
        }

        long num = Long.parseLong(left);
        List<Long> candidate = new ArrayList<>();
        candidate.add(findPalindrom(num, len%2==0));
        candidate.add(findPalindrom(num+1, len%2==0));
        candidate.add(findPalindrom(num-1, len%2==0));
        candidate.add((long)Math.pow(10, len-1)-1);
        candidate.add((long)Math.pow(10, len) + 1);

        long diff = Long.MAX_VALUE, res = 0, sVal = Long.parseLong(s);
        for(long cand : candidate){
            if(cand==sVal) continue;
            long currDiff = Math.abs(cand-sVal);
            if(currDiff < diff){
                diff = currDiff;
                res = cand;
            }else if(currDiff==diff){
                res = Math.min(res, cand);
            }
        }
        return res+"";
    }

    private long findPalindrom(long left, boolean even){
        long res = left;
        if(!even) left = left/10;
        while(left > 0){
            res = res * 10 + left%10;
            left /= 10;
        }
        return res;
    }
}
