package HashTable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _792_NumberOfMatchingSubsequence {

    //Time = O(s) + O(n * l * logs). n = # of words, l = len(word)
    //Space = o(s)

    /*
s = "acbca"
pos:
'a' : {0, 4}
'b' : {2}
'c' : {1, 3}
*/

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!indexMap.containsKey(c)){
                indexMap.put(c, new ArrayList<Integer>());
            }
            List<Integer> list = indexMap.get(c);
            list.add(i);
            indexMap.put(c, list);
        }

        int res = 0;
        for(String w : words){
            if(isSubseq(w, indexMap)){
                res++;
            }
        }
        return res;
    }

    private boolean isSubseq(String word, Map<Character, List<Integer>> map){
        int prevIdx = -1, curIdx = 0;
        while(curIdx < word.length()){
            char c = word.charAt(curIdx);
            if(!map.containsKey(c)) break;
            //use binarySearch to find if the character's index is exist in the list(in map)
            int index = binarySearch(prevIdx, map.get(c));
            if(index == -1) break;
            prevIdx = index;
            curIdx++;
        }
        if(curIdx==word.length()){
            return true;
        }
        return false;
    }

    private int binarySearch(int k, List<Integer> list){
        int left = 0, right = list.size()-1, res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int index = list.get(mid);
            if(k < index){
                res = index;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;
    }
}
