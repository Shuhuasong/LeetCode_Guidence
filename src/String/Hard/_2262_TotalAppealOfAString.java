package String.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _2262_TotalAppealOfAString {
    public long appealSum(String s) {
        long res = 0;
        int[] letterPos = new int[26];
        int n = s.length(), prev = 0;
        Arrays.fill(letterPos, -1);
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            prev = letterPos[c-'a'];
            res += (i-prev) * (n-i);
            letterPos[c-'a'] = i;
        }
        return res;
    }
}

/*
Solution-HashMap
1) since the constrains, the solution only can be
   O(nlogn) or O(n)
2) We need to count the number of character occurence for each letter,
   then we can scan the string and get the answer in the linear time.
3) e.g  "soda", the number of substring with letter 's' is :
   1 * 4 = # of left start point * # of right end point
4) for the duplicate character, xxxx a xxxx a xxx, the # of start point for
   second 'a' is  (j-i)
  */

