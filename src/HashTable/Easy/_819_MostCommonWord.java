package HashTable.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String newPara = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = newPara.split("\\s+");
        System.out.println("Size = " + words.length);
        Map<String, Integer> freq = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        for(String word : banned) banSet.add(word);
        int maxFreq = 0;
        String res = "";
        for(String w : words){
            if(!banSet.contains(w)){
                freq.put(w, freq.getOrDefault(w, 0)+1);
                if(freq.get(w) > maxFreq){
                    maxFreq = freq.get(w);
                    res = w;
                }
            }
        }
        return res;
    }
}
