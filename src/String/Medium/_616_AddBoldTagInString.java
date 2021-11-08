package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _616_AddBoldTagInString {

    //The length of s is limited, so we can try to go through s one time
    //Time = O(m*n*maxLen), m = s.length, n = words.length
    public String addBoldTag(String s, String[] words) {

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean[] mark = new boolean[n];

        for(int i=0; i<n; i++){
            for(String word : words){
                if(s.startsWith(word, i)){
                    for(int j=i; j<i+word.length(); j++){
                        mark[j] = true;
                    }
                }
            }
        }

        int l = 0, r = 0;
        while(l < n){
            if(mark[l]){
                r = l;
                while(r < n && mark[r]){
                    r++;
                }
                sb.append("<b>").append(s.substring(l, r)).append("</b>");
                l = r;
            }else{
                sb.append(s.charAt(l));
                l++;;
            }
        }
        return sb.toString();
    }

    //Iterate each word to check the string s from start to end, to see
    //if the word is match somewhere; if it does, then we mark the area
    //Time = O(m*n*maxLen), m = s.length, n = words.length
 /*   public String addBoldTag(String s, String[] words) {

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean[] mark = new boolean[n];
        for(String word : words){
            int l = word.length();
            for(int i=0; i<=n-l; i++){
                if(s.substring(i, i+l).equals(word)){
                    for(int j=i; j<i+l; j++){
                        mark[j] = true;
                    }
                }
            }
        }
        int l = 0, r = 0;
        while(l < n){
            if(mark[l]){
                r = l;
                while(r < n && mark[r]){
                    r++;
                }
                sb.append("<b>").append(s.substring(l, r)).append("</b>");
                l = r;
            }else{
                sb.append(s.charAt(l));
                l++;;
            }
        }
        return sb.toString();
    }

  */
}
