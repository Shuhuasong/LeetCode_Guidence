package DynamicProgramming.Medium;

import java.sql.Time;

public class _718_MaximumLengthOfRepeatedSubarray {
    //Time = O(m * n)  Space = O(m * n)
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        //dp[i][j] : the longest common subarray that ends at A[i]
        // and ends at B[j]
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    /*
     //Time = O(M*N*min(M, N))
    //Space = O(N)
    public int findLength(int[] A, int[] B) {
       Map<Integer, List<Integer>> bStart = new HashMap<>();
       int m = A.length, n = B.length;
       for(int i=0; i<n; i++){
           if(!bStart.containsKey(B[i])){
               bStart.put(B[i], new ArrayList<>());
           }
           bStart.get(B[i]).add(i);
       }
       int res = 0;
       for(int i=0; i<m; i++){
           if(bStart.containsKey(A[i])){
               for(int idx : bStart.get(A[i])){
                   int k = 0;
                   while(i+k<A.length && idx+k<B.length && A[i+k]==B[idx+k]){
                       k++;
                   }
                   res = Math.max(res, k);
               }
           }
       }
       return res;
    }
     */

    /*
     //Binary Search-LTE
    //Time = O((M+N)*min(M, N)*log(min(M,N)))
    //Space = O(N)
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int lo = 0, hi = Math.min(m,n)+1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(found(A, B, mid)){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo-1;
    }

    private boolean found(int[] A,int[] B, int len){
        Set<String> seen = new HashSet<>();
        for(int i=0; i+len<=A.length; i++){
            int[] copy = Arrays.copyOfRange(A, i, i+len);
            String s = Arrays.toString(copy);
            seen.add(s);
        }
        for(int j=0; j+len<=B.length; j++){
            int[] copy = Arrays.copyOfRange(B, j, j+len);
            String s = Arrays.toString(copy);
            if(seen.contains(s)) return true;
        }
        return false;
    }
     */
}


/*
B = [1,2,3,2,1]
A = [3,2,1,4,7]
Solution-1 (TLE):
Use Map record one of elem and its index

Solution-2 (TLE):
Binary Search With Naive Check
lo = 0, hi = 6 ===> mid = 3
found(A, B,3)==>
A : {{3, 2, 1}, {2, 1, 4}, {, 4, 7}}
         a
B = {{1, 2, 3}, {2, 3, 3}, {3, 2, 1}}  ==> a == b
                              b
Solution-3: DP--双序列DP

Find longest common subarray
 [X X X X X X i]
 [X X X X X X X X j]
 dp[i][j] ==> dp[i-1][j-1] + 1 if (A[i]==B[j]) else 0

similar with : Find longest common subsequence (LCS):DP
 dp[i][j] ==> dp[i-1][j-1] + 1 if (A[i]==B[j])
              min(dp[i-1][j], dp[i][j-1]) otherwise

*/
