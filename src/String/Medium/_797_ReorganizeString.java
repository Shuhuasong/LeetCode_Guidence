package String.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _797_ReorganizeString {

    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int count = 0;
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
            count = freq.get(c);
            if(count > (n+1)/2) return "";
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        for(char c : freq.keySet()){
            pq.add(new int[]{c, freq.get(c)});
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length()==0 || first[0] != sb.charAt(sb.length()-1)){
                sb.append((char)first[0]);
                if(--first[1] > 0){
                    pq.add(first);
                }
            }else{
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if(--second[1] > 0){
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}
