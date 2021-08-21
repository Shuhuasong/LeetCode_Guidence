package OnlineCodingChallege;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _CamelCaseSentence_ {

    private static String convert(String s){
        int n = s.length();
        String[] strs = s.split("\\s+");
        for(int i=0; i<strs.length; i++){
            String w = strs[i];
            strs[i] = Character.toUpperCase(w.charAt(0)) + w.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for(String w : strs){
            sb.append(w);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "I get intern at geeksforgeeks";
        System.out.println(convert(str));
    }
}
