package HashTable.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1152_AnalyzeUserWebsiteVisitPatter {
    class Visit{
        String web;
        int time;
        public Visit(int time, String web){
            this.time = time;
            this.web = web;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Visit>> userToVisit = new HashMap<>();
        for(int i=0; i<n; i++){
            userToVisit.putIfAbsent(username[i], new ArrayList<>());
            userToVisit.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }
        Map<String, Integer> seqToFreq = new HashMap<>();
        String res = "";
        for(String user : userToVisit.keySet()){
            Set<String> seen = new HashSet<>();
            List<Visit> visites = userToVisit.get(user);
            if(visites.size() < 3) continue;
            Collections.sort(visites, (a, b)->a.time-b.time);
            int size = visites.size();
            for(int i=0; i<size-2; i++){
                for(int j=i+1; j<size-1; j++){
                    for(int k=j+1; k<size; k++){
                        String seq = visites.get(i).web+"-"+visites.get(j).web+"-"+visites.get(k).web;
                        if(!seen.contains(seq)){
                            seqToFreq.put(seq, seqToFreq.getOrDefault(seq, 0)+1);
                            seen.add(seq);
                        }
                        if(res.equals("") || seqToFreq.get(res) < seqToFreq.get(seq) ||
                                seqToFreq.get(res) == seqToFreq.get(seq) && res.compareTo(seq) > 0){
                            res = seq;
                        }
                    }
                }
            }
        }
        String[] strs = res.split("-");
        List<String> results = new ArrayList<>();
        for(String st : strs) results.add(st);
        return results;
    }
}
