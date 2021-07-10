package DynamicProgramming.Medium;

public class _300_LongestIncreasingSubsequence {

    //Time = O(m * n) Space = O(m*n)
    public int findLength(int[] A, int[] B) {
        if(A.length==0 || B.length==0) return 0;
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return res;
    }

    /*
      //Time = O(n*log n) Space = O(n)
    //create a list, when find larger number, we add them into the list
    //if the number is smaller than last number, we will use binary search to find an insersion index for this number, to replace the number at this position.
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            int num = list.get(list.size()-1);
            if(nums[i] > num){
                list.add(nums[i]);
            }else{
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
                System.out.println(index + " " + nums[i]);
            }
        }
        return list.size();
    }

    public int binarySearch(List<Integer> list, int val){
        int left = 0, right = list.size()-1;
        int res = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(list.get(mid)==val) return mid;
            else if(list.get(mid) > val){
                right = mid - 1;
            }else{
                //res = mid;
                left = mid + 1;
            }
        }
        return left;
    }
    */
}
