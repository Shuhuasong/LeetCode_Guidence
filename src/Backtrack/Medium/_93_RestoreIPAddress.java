package Backtrack.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _93_RestoreIPAddress {

    List<String> results = new ArrayList<>();
    LinkedList<String> segements = new LinkedList<>();
    int n;
    String s;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return results;
    }

    public void backtrack(int prePos, int dots){
        int maxPos = Math.min(n-1, prePos+4);
        for(int i=prePos+1; i<maxPos; i++){
            String sub = s.substring(prePos+1, i+1);
            if(isValid(sub)){
                segements.add(sub); //place dot
                if(dots-1==0){ //if all 3 dots are placed
                    getResult(i); // i == curr position
                }else{
                    backtrack(i, dots-1);//continue to place dots
                }
                segements.removeLast(); // remove the last placed dot
            }
        }
    }

    public boolean isValid(String seg){
        int len = seg.length();
        if(len > 3) return false;
        if(seg.charAt(0) == '0'){
            return len==1;
        }else{
            return Integer.valueOf(seg) <= 255;
        }
    }

    public void getResult(int curPos){
        //Append the current list of segements to the list of Solutions
        String lastSub = s.substring(curPos+1, n);
        if(isValid(lastSub)){
            segements.add(lastSub);
            results.add(String.join(".", segements));
            segements.removeLast();
        }
    }
}
