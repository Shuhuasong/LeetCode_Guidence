package String.Hard;

/**
 * Created by Shuhua Song
 */

//DFS
public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        if(p.length() == 0) return s.length()==0;

        boolean firstMatch = (s.length() > 0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'));
        //with '*'
        if(p.length()>=2 && p.charAt(1)=='*'){
            //s = "aab", p = "c*a*b"
            return isMatch(s, p.substring(2)) ||
                    //s = "aaaaa", p = "a*
                    (firstMatch && isMatch(s.substring(1),p));
        }else{
            //no '*'
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /*
      //Time = O(m*n), Space = O(m*n)
   public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        //dp[i][j] : the length with i in s, and the length j in p are match
        boolean[][] dp = new boolean[m+1][n+1];
        //empty string for both
        dp[0][0] = true;
        for(int j=2; j<=n; j++){
           if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-2];
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if(sc==pc || pc=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc=='*'){
                    if(dp[i][j-2]){
                        //not use preceeding char
                        dp[i][j] = true;
                    }else if(sc==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        //use multiple times
                        //s = "aaaaa", p = "aa*aa"
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
     */
}

/*
case 1 : s = "aa", p = "a"==> false;
case 2 : s = "aa", p = "a*"==> true;
case 3 : s = "aab", p = "c*a*b"==> true; * repeat 0 time of c, * = a
case 4 : s = "ab", p = ".*" ==> with 2 dot,  true; . = a, . = a
s = commitee
p = com*te* ===> no i

Solutio-1: DFS===> Time Complexity: exponencial
 s = "ab", p = ".*"
1)  use first char
firstMatch = s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'
2)  or do not use first char in p
 case 0: p.length() >= 2 && p.charAt(1)=='*'
         isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1),p))
             not use first char             use first char
                                            e.g  s = aaaaa
                                            p = a*
 case 1: regular case
         firstMatch && isMatch(s.substring(1), p.substring(1))
Summary:
-- check chars one by one
   firstMatch = same || p.charAt(0)=='.'
-- check the rest string
   if  (second char is '*')
       1) use first char 0 times ==> isMatch(s, p.substring(2))
       2) use first char multiple times
                ==> firstMatch && isMatch(s.substring(1), p)
   else just check the rest
        firstMatch && isMatch(s.substring(1), p.substring(1))


Solution-2: DP-kind like question edit distance
s = length m
p = length n
boolean[][] dp = new boolean[m+1][n+1];
dp[0][0] = true;
_* : use 0 preceding element
     use multiple times of preceeding element
essentially
//match an empty string
     for(int i=2; i<=n; i++){
        if(p.charAt(i-1)=='*'){//match a empty string in s
          dp[0][i] = dp[0][i-2];  //s = "aa", p = "a*"
        }
     }
iterate two string, match one by one
for each length of S, use t to match it
char sc = s.charAt(i-1);
char pc = p.charAt(j-1);
case 0: sc==pc || pc=='.'
        dp[i][j] = dp[i-1][j-1]
case 1: pc == '*'
        if dp[i][j-2] not use preceeding char
           dp[i][j] = true;
        else if sc == p.charAt(j-2) || p.charAt(j-2)=='.' //use multiples times
            dp[i][j] = dp[i-1][j]  //suppose is use once dp[1][2] = dp[0][2]
            transitive if use more than once than value passes on
S = aaaa
P = a*

dp
  s 0  1  2  3  4
p
0   T
1      T
2   T  T  T  T  T
3
*/

