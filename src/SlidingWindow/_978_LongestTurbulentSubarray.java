package SlidingWindow;

/**
 * Created by Shuhua Song
 */
public class _978_LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        int start = 0, maxLen = 1;
        int diff = 0, n = arr.length;
        for(int i=1; i<n; i++){
            diff = Integer.compare(arr[i-1], arr[i]);
            if(diff==0){
                start = i;
            }else if(i==n-1 || diff * Integer.compare(arr[i], arr[i+1]) != -1){
                maxLen = Math.max(maxLen, i-start+1);
                start = i;
            }
        }
        return maxLen;
    }



    /*

     DP
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, res = 1;
        int[] dp = new int[n];
        char prev = '=';
        // beginning of new subarray if curr is same as previous, so set to len = 1
    dp[0] = 1;
        for(int i=1; i<n; i++){
        char curr = (arr[i] > arr[i-1] ? '>' : arr[i] < arr[i-1] ? '<' : '=');
        if(curr=='='){
            dp[i] = 1;
        }else{
            dp[i] = (curr==prev ? 2 : dp[i-1]+1);  //(1)
        }
        prev = curr;
        res = Math.max(res, dp[i]);
    }
        return res;
}

 (1)         If not same then we check if pattern expected to form a subarray holds or not.
               i.e. say for subarray len = 5 pattern must be either: "><><>" or "<><><".
               If the condition holds we add 1 to the previous DP states result else we start a new subarray
               from the previous index so we assign the current DP state to 2.

 */


   /*
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 0, len = 1;
        int n = arr.length;
        if(n<=1) return n;
        for(int i=0; i<n-1; i++){
            if((arr[i] > arr[i+1] && i%2==1) || (arr[i] < arr[i+1] && i%2==0)){
                len++;
                System.out.println(len);
            }else{
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);
        System.out.println("maxLen = " + maxLen);
        len = 1;
        for(int i=0; i<n-1; i++){
            if((arr[i] > arr[i+1] && i%2==0) || (arr[i] < arr[i+1] && i%2==1)){
                len++;
            }else{
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    } */
}
