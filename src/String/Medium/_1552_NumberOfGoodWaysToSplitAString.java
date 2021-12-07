package String.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1552_NumberOfGoodWaysToSplitAString {

    public int numSplits(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        Set<Character> rightSet = new HashSet<>();
        Set<Character> leftSet = new HashSet<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n; i++){
            leftSet.add(s.charAt(i));
            left[i] = leftSet.size();
        }
        for(int i=n-1; i>=0; i--){
            rightSet.add(s.charAt(i));
            right[i] = rightSet.size();
        }
        int res = 0;
        for(int i=0; i<n-1; i++){
            if(left[i]==right[i+1]){
                res++;
            }
        }
        return res;
    }

    /*
      public int numSplits(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int[] left = new int[n];
        for(int i=0; i<n; i++){
            set.add(s.charAt(i));
            left[i] = set.size();
        }
        set.clear();
        int res = 0;
        for(int i=n-1; i>0; i--){
            set.add(s.charAt(i));
            if(set.size()==left[i-1]){
                res++;
            }
        }

        return res;
    } 
     */
}
