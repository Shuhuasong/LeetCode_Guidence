package HashTable.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _792_NumberOfMatchingSubsequences {
    //Time = O(words.length * s.length + SUM(words[i].length))
    //Space = O(n)
    public int numMatchingSubseq(String s, String[] words) {
        if(s==null || s.length()==0)  return 0;
        int count = 0;
        Set<String> seen = new HashSet<>();
        Set<String> notSub = new HashSet<>();
        for(String word : words){
            if(notSub.contains(word)) continue;
            if(seen.contains(word)){
                count++;
                continue;
            }
            if(isSubseq(s, word)){
                // System.out.println(word);
                count++;
                seen.add(word);
            }else{
                notSub.add(word);
            }
        }
        return count;
    }

    private boolean isSubseq(String s, String w){
        if(w.length() > s.length()) return false;
        int i=0, j=0;
        while(i<s.length() && j<w.length()){
            if(s.charAt(i)==w.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        if(i==s.length() && j!=w.length()) return false;
        return j==w.length();
    }

    /*
    //Time = O(s.length + SUM(words[i].length))
    //Time = O(s.length)
    public int numMatchingSubseq(String s, String[] words) {
        if(s==null || s.length()==0 || words.length==0) return 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            List<Integer> list = map.get(c);
            list.add(i);
            map.put(c, list);
        }
        int res = 0;
        for(String w : words){
            if(isSub(w, map)){
                res++;
            }
        }
        return res;
    }

    private boolean isSub(String w, Map<Character, List<Integer>> map){
        int prevIdx = -1, curIdx = 0;
        for(int i=0; i<w.length(); i++){
            char c = w.charAt(i);
            if(!map.containsKey(c)) return false;
            int index = binarySearch(prevIdx, map.get(c));
            if(index==-1) return false;
            prevIdx = index;
        }
        return true;
    }

    private int binarySearch(int target, List<Integer> list){
        int left = 0, right = list.size()-1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int index = list.get(mid);
            if(index > target){
                res = index;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
     */
}
