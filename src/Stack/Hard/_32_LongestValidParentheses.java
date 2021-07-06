package Stack.Hard;

import java.util.Stack;

public class _32_LongestValidParentheses {

    /*    0 1  2  3  4  5  6  7
     S = "( )  )  (  (  (  )  )"

    maxLen  = 1 - (-1) = 2
            = 6 - 4 = 2
            = 7 - 3 = 4
*/

    //Time = O(n) Space = O(n) ==> Time Limit Exceed
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0) return 0;
        int maxLen = 0, n = s.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxLen = Math.max(maxLen, i-st.peek());
                }
            }
        }
        return maxLen;
    }
    /*
      //Time = O(n) Space = O(1) ==> Time Limit Exceed
   public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen = Math.max(maxLen, 2*right);
            }else if(right > left){
                left = right = 0;
            }
            System.out.println(left + " " + right + " " + maxLen);
        }
        left = right = 0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen = Math.max(maxLen, 2 * left);
            } else if(left > right){
                left = right = 0;
            }
             System.out.println(left + " " + right + " " + maxLen);
        }
       return maxLen;
    }
     */
}
