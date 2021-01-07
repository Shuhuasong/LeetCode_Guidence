package Depth_First_Search.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_LetterCombinationOfAPhoneNumber {

    //DFS : O(3^N * 4^M) N: the number of digits in the input that maps to 3 letters
    // M: the number of digits in the input that maps to 4 letters
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits==null || digits.length()==0) return results;
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "abc"); map.put(3, "def");
        map.put(4, "ghi"); map.put(5, "jkl");
        map.put(6, "mno"); map.put(7, "pqrs");
        map.put(8, "tuv"); map.put(9, "wxyz");

        combination(digits, "", map, results);
        return results;
    }

    private void combination(String digits, String curStr, HashMap<Integer, String> map, List<String> results){
        if(digits.length()==0){
            results.add(curStr);
            return;
        }
        int val = digits.charAt(0) - '0';
        String keys = map.get(val);
        char[] chs = keys.toCharArray();
        for(int i=0; i<chs.length; i++){
            curStr = curStr + chs[i];
            combination(digits.substring(1), curStr, map, results);
            curStr = curStr.substring(0,curStr.length()-1);
        }
    }
}
