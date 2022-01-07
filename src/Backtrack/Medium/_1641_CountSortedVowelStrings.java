package Backtrack.Medium;

/**
 * Created by Shuhua Song
 */
public class _1641_CountSortedVowelStrings {

    /*
      //5- Math
      //Time = O(1), O(1)
     public int countVowelStrings(int n) {
       return ((n+4)*(n+3)*(n+2)*(n+1))/24;
    }
     */

    /*
      //4- DP
      //Time = O(n^5), Space = O(n)
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for(int vowels=1; vowels<=5; vowels++){
            dp[1][vowels] = vowels;
        }
        for(int nVal=2; nVal<=n; nVal++){
            dp[nVal][1] = 1;
            for(int vowels=2; vowels<=5; vowels++){
                dp[nVal][vowels] = dp[nVal-1][vowels] + dp[nVal][vowels-1];
            }
        }
        return dp[n][5];
    }
     */

    //3- Recursion + Memoization
    //Time = O(n^5), Space = O(n)
    public int countVowelStrings(int n) {
        int[][] memo = new int[n+1][5+1];
        return count(n, 5, memo);
    }

    private int count(int n, int vowels, int[][] memo){
        //only one position left,return current number of vowels
        if(n==1) return vowels;
        if(vowels==1) return 1;
        if(memo[n][vowels] != 0) return memo[n][vowels];
        memo[n][vowels] = count(n, vowels-1, memo) + count(n-1, vowels, memo);
        return memo[n][vowels];
    }

    /*
       //2-Decoding the Pattern, Using Recursion
      //Time = O(n^5), Space = O(n)
    public int countVowelStrings(int n) {
        return count(n, 5);
    }

    private int count(int n, int vowels){
        //only one position left,return current number of vowels
        if(n==1) return vowels;
        if(vowels==1) return 1;
        return count(n, vowels-1) + count(n-1, vowels);
    }
     */


    /*
     //1-Backtrack
     //Time = O(n^5), Space = O(n)
    public int countVowelStrings(int n) {
        return count(n, 1);
    }

    private int count(int n, int vowels){
        //when n==0, we reach the end of the string and found one combination
        if(n==0) return 1;
        int res = 0;
        for(int i=vowels; i<=5; i++){
            res += count(n-1, i);
        }
        return res;
    }
     */
}


/*
        Solution-1: Backtracking

        a=1,e=2,i=3,o=4,u=5


        Solution-2: Decoding the Pattern, Using Recursion

        Count(2, 3)==>N=2,vowels=3{a,e,i}==> res = 6
        ==>{aa, ae, ai, ee, ei, ii}
        Count(1, 4)==>N=1,vowels=4{a,e,i,o}==> res = 4
        ==>{a,e,i,o}
        Count(2, 4)==>N=2,vowels=4{a,e,i,o}==> res = 10
        ==>{aa,ae,ai,ee,ei,ii + ao,eo,io,oo}
        Count(N=2, vowels=4)==>
        Count(N=1, vowels=4) + Count(N=2, vowels=3)
        Conclution:
        Count(n, vowels) = Count(n,vowels-1)+Count(n-1,vowels)


        Solution-3: Solve Overlapping Subproblem
        Recursion + Memoization

        Solution-4: Bottom Up Dynamic Programming
        use the iterative approach and store the result of subproblems
        in bottom-up fashion(Tabulation)
        dp[n][vowels]= the total number of combiations of given n and number of vowels
        dp[n][vowels] = dp[n-1][vowels] + dp[n][vowels];

        Solution-5: Math
        Transfer the problem:
        given 5 vowels (let k=5), we want to find the number of combinations using only n
        vowels. We can repeat vowels many times.
        Combination With repitition:
        From k vowels(k=5), we can choose n vowels with repetition
        choose n from k
        C(n,k) = (k+n-1)!/(k-1)!*n!  ==> k = 5
        C(n,5) = [(n+4)*(n+3)*(n+2)*(n+1)]/24
        */