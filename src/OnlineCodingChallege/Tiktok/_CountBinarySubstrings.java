package OnlineCodingChallege.Tiktok;

/**
 * Created by Shuhua Song
 */
public class _CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int prev = 0, curr = 1;
        int count = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            }else{
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        count += Math.min(prev, curr);
        return count;
    }
}
