package OnlineCodingChallege.Amazon;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */

/*
Value over a period = (Contiuous sum * Minimum rating in that period)

eg: [3, 1, 6, 4, 5, 2]
Value could be (3+1+6+4+5+2) * 1 = 21.

Find the maximum value.
Here max value is (6+4+5) * 4 = 60.

O(N2) won't pass most test cases.
 */
public class _WinningSequence_ {

    static long findMaxValue(int[] ratings) {
        int n = ratings.length;

        if (n == 0) return 0;

        int[] sumRatings = new int[n];
        sumRatings[0] = ratings[0];
        for (int i=1;i<n;i++) {
            sumRatings[i] = sumRatings[i-1] + ratings[i];
        }

        // Keeps track of the index of the first min value to the left of this number
        int[] prevMinIndex = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;i<n;i++) {
            while (!st.isEmpty() && ratings[i] <= ratings[st.peek()]) {
                st.pop();
            }
            prevMinIndex[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Keeps track of the index of the first min value to the right of this number
        int[] nextMinIndex = new int[n];
        st = new Stack();
        for (int i = n-1;i>=0;i--) {
            while (!st.isEmpty() && ratings[i] < ratings[st.peek()]) {
                st.pop();
            }
            nextMinIndex[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Now for each rating, we'd compute the value
        // we'd consider the subArray in which that rating is minimum which we'll be, nextMinIndex[i] - 1 to  prevMinIndex[i] + 1,
        // within this range the rating is the minimum
        // to get the sum of elements in that subArray, we use sumRatings which holds the cumulative sum of the ratings
        long maxVal = 0, leftSum;
        for (int i = 0;i<n;i++) {
            leftSum = prevMinIndex[i] == -1 ? 0 : sumRatings[prevMinIndex[i]];
            maxVal = Math.max(maxVal, (sumRatings[nextMinIndex[i]-1] - leftSum) * ratings[i]);
        }
        return maxVal;
    }
   /* private static int findMaxValue(int[] rates){
        if(rates==null || rates.length==0) return 0;
        int n = rates.length, sum = 0, min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<n; i++){
            sum = 0;
            for(int j=i; j<n; j++){
                min = Math.min(min, rates[j]);
                sum += rates[j];
            }
            res = Math.max(res, sum * min);
        }
        return res;
    } */
  /* private static void findMaxValue(int[] arr) {
       int n = arr.length;
       int[] ansL = new int[n];
       int[] ansR = new int[n];
       Stack<Integer> st = new Stack();
       int i=0;
       for(i=0; i<n; ) {
           if(st.isEmpty() || arr[i] >= arr[st.peek()]) {
               st.push(i);
               i++;
           } else {
               int top = st.pop();
               if(st.isEmpty()) {
                   ansR[top] = i-1;
                   ansL[top] = 0;
               } else {
                   ansR[top] = i-1;
                   ansL[top] = st.peek()+1;
               }
           }
       }

       while(!st.isEmpty()) {
           int top = st.pop();
           if(st.isEmpty()) {
               ansR[top] = n-1;
               ansL[top] = 0;
           } else {
               ansR[top] = n-1;
               ansL[top] = st.peek()+1;
           }
       }

       for(int k=0; k<n; k++) {
           System.out.println("l: " + ansL[k] + " r: " + ansR[k]);
       }


       int[] cumSum = new int[n+1];
       cumSum[0] = 0;
       for(int k=1; k<=n; k++) {
           cumSum[k] = arr[k-1] + cumSum[k-1];
       }
       for(int k=0; k<=n; k++) {
           System.out.println("cumSum: i " + k + " value:  " + cumSum[k]);
       }

       int ans = 0;
       for(int k=0; k<n; k++) {
           ans = Math.max(ans, (cumSum[ansR[k]+1] - cumSum[ansL[k]])*(arr[k]));
       }

       System.out.println("Ans : " + ans);
   } */

    public static void main(String[] args) {
           int[] rates = {3, 1, 6, 4, 5, 2};
        //findMaxValue(rates);
        System.out.println(findMaxValue(rates));
    }

}
