package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _1592_RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int len = text.length();
        text = text.trim();
        String[] strs = text.split("\\s+");
        int wordLen = 0;
        for(String str : strs){
            wordLen += str.length();
        }
        int spaces = len - wordLen;
        System.out.println("spaces = " + spaces);
        int n = strs.length;
        int cnt = 0, rem = 0;
        if(n-1 > 0){
            cnt = spaces/(n-1);
            rem = spaces % (n-1);
        }else{
            cnt = 0;
            rem = spaces;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
            for(int i=0; i<cnt; i++){
                sb.append(" ");
            }
        }
        String res = sb.toString().trim();
        if(rem != 0){
            for(int i=0; i<rem; i++){
                res += " ";
            }
        }
        return res;
    }
}
