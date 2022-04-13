package HashTable.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _937_ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        TreeMap<String, List<String>> letterMap = new TreeMap<>();
        List<String> digitLogs = new ArrayList<>();
        for(String log : logs){
            String[] splits = log.split("\\s+", 2);
            char firstChar = splits[1].charAt(0);
            if(Character.isDigit(firstChar)){
                digitLogs.add(log);
            }else{
                letterMap.putIfAbsent(splits[1], new ArrayList<>());
                letterMap.get(splits[1]).add(splits[0]);
            }
        }
        int n = logs.length;
        int i = 0;
        String[] results = new String[n];
        for(String content : letterMap.keySet()){
            List<String> currList = letterMap.get(content);
            Collections.sort(currList);
            for(String id : currList){
                results[i++] = id + " " + content;
            }
        }
        for(String digit : digitLogs){
            results[i++] = digit;
        }

        return results;
    }

    /*
     //Time = O(M*NlogN), arrays.sort(nlogn), n = logs.length, M = max length of log
    //Space = O(M*logN)
    public String[] reorderLogFiles(String[] logs) {
            Comparator<String> myComp = new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    //split each log into two parts : <identifier, content>
                    String[] strs1 = s1.split(" ", 2);
                    String[] strs2 = s2.split(" ", 2);

                    boolean isDigit1 = Character.isDigit(strs1[1].charAt(0));
                    boolean isDigit2 = Character.isDigit(strs2[1].charAt(0));
                    //case 1: both logs are letter logs
                    if (!isDigit1 && !isDigit2) {
                        //first compare the content
                        int comp = strs1[1].compareTo(strs2[1]);
                        if (comp != 0) {
                            return comp;
                        }
                        //logs of same content, compare the identifiers
                        return strs1[0].compareTo(strs2[0]);
                    }
                    //case 2 : one of logs is digit-log
                    //log1==letter log, log2 = digit log
                    if (!isDigit1 && isDigit2) {
                        //the letter-log comes before digit-log
                        //want to make log1 as s2, so s1 < s2==-1
                        return -1;
                    } else if (isDigit1 && !isDigit2) {
                        //log1 = digit, log2 = letter
                        //if we want to order in this way : log2 log1
                        //we want to push log1 in the bottom
                        //we consider log1 > log2, so ==>return 1, elem1 > element 1
                        return 1;
                    } else {
                        //case3 : both logs are digit-log
                        return 0;
                    }
                }
            };
            Arrays.sort(logs, myComp);
            return logs;
     }
     */

    /*   //Time = O(M*NlogN), arrays.sort(nlogn), n = logs.length, M = max length of log
    //Space = O(M*N)
     public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b)->{
            if(a[1].equals(b[1])) return a[0].compareTo(b[0]);
            else{
                return  a[1].compareTo(b[1]);
            }
        });
        List<String> digits = new ArrayList<>();
        for(String log : logs){
            String[] words = log.split(" ", 2);
            String id = words[0], content = words[1];
            if(Character.isDigit(content.charAt(0))){
                digits.add(log);
            }else{
                pq.add(new String[]{id, content});
            }
        }
        String[] res = new String[logs.length];
        int k = 0;
        while(!pq.isEmpty()){
            String[] cell = pq.poll();
            res[k++] = cell[0] + " " + cell[1];
        }
        for(String log : digits){
            res[k++] = log;
        }
        return res;
    }
     */
}
