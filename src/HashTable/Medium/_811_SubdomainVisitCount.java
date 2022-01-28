package HashTable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _811_SubdomainVisitCount {
    //Time = O(N*M), N = # of domain, M = maxLen of domain
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        for(String domain : cpdomains){
            String[] splits = domain.split("\\s+");
            int time = Integer.parseInt(splits[0]);

            String[] subs = splits[1].split("\\.");
            int n = subs.length;

            StringBuilder sb = new StringBuilder();
            for(int i=n-1; i>=0; i--){
                if(i==n-1){
                    sb.insert(0, subs[i]);
                }else{
                    sb.insert(0, ".");
                    sb.insert(0, subs[i]);
                }
                String currDom = sb.toString();
                freq.put(currDom, freq.getOrDefault(currDom, 0)+time);
            }
        }

        for(String key : freq.keySet()){
            int time = freq.get(key);
            results.add(time + " " + key);
        }

        return results;
    }
}
