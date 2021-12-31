package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _246_StrobogrammaticNumber {

        //Two Pointer : Time = O(n)
        public boolean isStrobogrammatic(String num) {
            int n = num.length();
            Map<Character, Character> map = new HashMap<>();
            map.put('0', '0'); map.put('1', '1');
            map.put('6', '9'); map.put('9', '6');
            map.put('8', '8');
            for(int l=0, r=n-1; l<=r; l++, r--){
                char leftC = num.charAt(l);
                char rightC = num.charAt(r);
                if(!map.containsKey(leftC) || map.get(leftC)!=rightC){
                    return false;
                }
            }

            return true;
        }


    /*
        int n = num.length();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0'); map.put('1', '1');
        map.put('6', '9'); map.put('9', '6');
        map.put('8', '8');
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--){
            char c = num.charAt(i);
            if(!map.containsKey(c)) return false;
            char ch = map.get(c);
            sb.append(ch);
        }
        String res = sb.toString();
        // System.out.println(res + " " + num);
        return res.equals(num);  */
}
