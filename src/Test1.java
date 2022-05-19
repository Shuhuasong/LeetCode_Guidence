import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class Test1 {
    public static List<String> findRepeatWord(String paragrap){
        String[] words = paragrap.split("\\s+");
        List<String> results = new ArrayList<>();
        if(words.length==0) return results;
        int count = 1, left = 0;
        for(int r=1; r<words.length; r++){
            if(words[r].equals(words[r-1])){
                count++;
            }else{
                if(count > 1){
                    String sub = findSequece(words, left, r);
                    results.add(sub);
                }
                count = 1;
                left = r;
            }
        }
        if(count > 1){
            String sub = findSequece(words, left, words.length);
            results.add(sub);
        }
        return results;
    }

    public static String findSequece(String[] words, int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<end; i++){
            sb.append(words[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        String sub = sb.toString();
        return sub;
    }

    public static void main(String[] args) {
        String paragraph = "one two two three go go go big small big how sample test text to do it default\n" +
                "returns string string is is in seconds since what is the end end";
        List<String> result = findRepeatWord(paragraph);
    }
}
