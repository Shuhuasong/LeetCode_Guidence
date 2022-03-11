package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _1963_MinimumNumberOfSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        int close = 0, open = 0, n = s.length();
        char[] chs = s.toCharArray();
        int l = 0, r = n-1;
        int res = 0;
        while(l < r){
            if(chs[l]=='['){
                open++;
            }else{
                close++;
            }
            if(close > open){
                while(r > l && chs[r]==']'){
                    r--;
                }
                res++;
                close--;
                open++;
                //chs[r] = ']';
                //chs[l] = '[';
            }
            l++;
        }
        return res;
    }
}

/*
Note:
1) Iterate over the string and keep track of the number of opening and closing brackets on each step.
2) If the number of closing brackets is ever larger, you need to make a swap.
*/
