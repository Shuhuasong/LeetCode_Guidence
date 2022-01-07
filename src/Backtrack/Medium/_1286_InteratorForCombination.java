package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1286_InteratorForCombination {

    List<String> list;
    int idx = 0;
    public _1286_InteratorForCombination(String characters, int len) {
        list = new ArrayList<>();
        char[] chs = characters.toCharArray();
        StringBuilder sb = new StringBuilder();
        backtrack(chs, 0, sb, len);
    }

    private void backtrack(char[] chs, int idx, StringBuilder sb, int len ){
        if(sb.length()==len){
            list.add(sb.toString());
            return;
        }
        for(int i=idx; i<chs.length; i++){
            sb.append(chs[i]);
            backtrack(chs, i+1, sb, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        String res = "";
        if(idx < list.size()){
            res = list.get(idx);
            idx++;
        }
        return res;
    }

    public boolean hasNext() {
        return idx < list.size();
    }
}
