package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _678_ValidParenthesisString {


    public boolean checkValidString(String s) {
        Stack<Integer> charSt = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                charSt.push(i);
            }else if(c=='*'){
                star.push(i);
            }else {
                if(!charSt.isEmpty()){
                    charSt.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!charSt.isEmpty() && !star.isEmpty()){
            int chIdx = charSt.pop();
            int starIdx = star.pop();
            //the index of  '(' must smaller than '*'
            //otherwise, false
            if(chIdx > starIdx) return false;
        }
        if(!charSt.isEmpty()) return false;
        return true;
    }


    /*
     public boolean checkValidString(String s) {
        int min = 0, max =0;
        for(char c : s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }else if(c==')'){
                max--;
                min = Math.max(min-1, 0);
            }else{
                max++;
                min = Math.max(min-1, 0);
            }
            if(max < 0) return false;
        }
        return min==0;
    }
     */
}


/*
solution-Stack

leftStack )
starStack *
step1: ( push to leftStack
       * push to starStack
       )  1) leftStack not empty poll means it's matching
          2) starStack not empty *appear before ). treat * as left '(' --> eg: *)
          3) ).  return false;
step2:  * (   index > star

        pair: (index, ( ) *)


use one stack to collect index of '(',
and one stack to collect index of '*'.
when there is ')', we cancel one elem in charStack or starStack
if both are empty, no char match with curr ')' then return false;

if there exist pair :  * (
charIdx > starIdx, then it can't match, return false;

after iterate the whole string, check if elem in both stack are match
if match, then pop; otherwise, return false;


Solution-DP
Time complexity = O(n^3),
Space complexity = O(n^2)

left = '(' || '*', right = ')' || '*'
case-1: nested match
 L LLLRRR R ===> LLLLRRRR
 _        _
case-2: append match
L.....R L......R
-------+---------
dp[i][i] = true if s[i] = '*'
if dp[i+1][j-1] and s[i] in L and s[j] in R
   dp[i][j] = true;
for k in i...j-1
    if dp[i][k] && dp[k+1][j]
    dp[i][j] = true

Solution -- count
One pass for the string s
Algorithm:
1) count the number of ')' we curr have, and it is
   equal to the number of '('
   the number will in the range [min, max]
2) min : count the minimum '(', which means
   the number of unbalanced '(' that must be paired;
3) max : count the maximum '(', which means
   the number of unbalanced '(' that could be paired optional;

e.g  when '(' ==> min = 1, max = 1
     when "(*(" ==> min = 1, max = 3
2 condition must valid:
  1) max will never be negative(cannot have too many ')')
  2) min is 0 at the end
*/




    /*
      int[][] memo;
    public boolean checkValidString(String s) {
        int n = s.length();
       memo = new int[n][n];
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }
        return isValid(s, 0, n-1);
    }

    private boolean isValid(String s, int l, int r){
        if(l > r) return true;
        if(memo[l][r] >= 0) return memo[l][r]==1;
        if(l==r){
            memo[l][r] = (s.charAt(l)=='*') ? 1 : 0;
            return memo[l][r] == 1;
        }

        char firstC = s.charAt(l), lastC = s.charAt(r);
        if((firstC=='(' || firstC=='*') && (lastC==')' || lastC=='*')
            && isValid(s, l+1, r-1)){
             memo[l][r] == 1;
            return memo[l][r] == 1;
        }
        for(int k=l; k<r; k++){
            if(isValid(s, i, k) && isValid(s, k+1, r)){
                return memo[l][r] = 1;
            }
        }
        memo[l][r] = 0;
        return false;
    }
     */

