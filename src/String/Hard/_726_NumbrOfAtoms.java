package String.Hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _726_NumbrOfAtoms {
    //Time = O(n)
    //Space = O(n)
    int i;
    public String countOfAtoms(String s) {
        if(s==null || s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        i = 0;
        TreeMap<String, Integer> map = countAtoms(s.toCharArray());
        for(String key : map.keySet()){
            sb.append(key);
            if(map.get(key) > 1){
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> countAtoms(char[] chs){
        TreeMap<String, Integer> counts = new TreeMap<>();
        while(i != chs.length){
            char c = chs[i];
            if(c == '('){
                i++;
                Map<String, Integer> temp = countAtoms(chs);
                int time = getCount(chs);
                for(Map.Entry<String, Integer> entry : temp.entrySet()){
                    counts.put(entry.getKey(), counts.getOrDefault(entry.getKey(), 0)+
                            entry.getValue()*time);
                }
            }else if(c == ')'){
                i++;
                return counts;
            }else{
                String name = getName(chs);
                int time = getCount(chs);
                counts.put(name, counts.getOrDefault(name, 0)+time);
            }
        }
        return counts;
    }

    private String getName(char[] ch){
        String s = "" +  ch[i++];
        while(i<ch.length && ch[i]>='a' && ch[i]<='z'){
            s += ch[i];
            i++;
        }
        return s;
    }

    private int getCount(char[] ch){
        int count = 0;
        while(i < ch.length && ch[i]>='0' && ch[i]<='9'){
            count = count * 10 + (ch[i] - '0');
            i++;
        }
        return count==0 ? 1 : count;
    }
}
/*
Sorted Key : TreeMap<String, Integer>
Solution: write function to parse a formula wihtout "()",
use recursion to parse formula within "()"
if no "()", only needs to implement two functions:
getName() / getCount()
Time complexity : O(n)
Space complexity: O(n)
*/