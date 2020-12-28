package Math;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {

    public int RomanToInteger(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        int n = s.length();
        int result = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while(i<n){
            if(i+1 < n && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i = i+1;
            }else{
                result += map.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
