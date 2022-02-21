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
}
