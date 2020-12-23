package TwoPointer;

import java.util.HashSet;

public class _3_LongestSubstringWithoutRepeatingCharacters {

    //Two Pointer(same direction) : Time = O(n) Space = O(1)
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==0) return 1;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0, right = 0, result = 0;
        while(right < n){
            if(set.add(s.charAt(right))){
                right++;//need to move right pointer first
                result = Math.max(result, right-left);
            }else{
                set.remove(s.charAt(left));// need to remove the element in the set first, then move pointer forward
                left++;

            }
        }
        return result;
    }

    /*
     public int lengthOfLongestSubstring(String s) {
      if(s==null) return -1;
       if(s.length()==0) return 0;
       int result = 0, n = s.length();
       int i=0;
       Set<Character> set = new HashSet<>();
       for(int j=0; j<n; ){
           char ch = s.charAt(j);
           while(!set.add(ch)){
             set.remove(s.charAt(i));
             i++;
           }
           j++;
           result = Math.max(result, j-i);
       }
       return result;
    }
    */
}
