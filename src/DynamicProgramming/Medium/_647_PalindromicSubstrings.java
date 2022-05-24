package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] isPalin = new boolean[n][n];
        for(int i=0; i<n; i++){
            isPalin[i][i] = true;
        }
        count += n;
        for(int j=1; j<n; j++){
            for(int i=0; i<j; i++){
                boolean isInnerPalin = (j-i<=2 || isPalin[i+1][j-1]);
                if(s.charAt(i)==s.charAt(j) && isInnerPalin){
                    count++;
                    isPalin[i][j] = true;
                }
            }
        }
        return count;
    }
}
