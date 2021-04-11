package Array.Medium;

import java.util.HashSet;

public class _792_NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        HashSet<String> subSeq = new HashSet<>();
        HashSet<String> notSub = new HashSet<>();
        for(String word : words){
            if(subSeq.contains(word)){
                result++;
                continue;
            }
            if(notSub.contains(word)){
                continue;
            }
            if(isSequence(s, word)){
                subSeq.add(word);
                result++;
            }else{
                notSub.add(word);
            }
        }
        return result;
    }

    public boolean isSequence(String s, String sub){
        if(sub==null || s.length()==0) return true;
        int p1 = 0;
        int p2 = 0;
        while(p1 < s.length() && p2 < sub.length()){
            if(s.charAt(p1)==sub.charAt(p2)){
                p2++;
            }
            p1++;
        }
        return p2 == sub.length();
    }
}
