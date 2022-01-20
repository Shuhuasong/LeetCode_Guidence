package Design;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _635_DesignLogStorageSystem {

    //TreeMap: Time = O(logn)
    private TreeMap<String, HashSet<Integer>> records;
    private Map<String, Integer> indexMap;
    private String min = "2000:01:01:00:00:00";
    private String max = "2017:12:31:23:59:59";
    public _635_DesignLogStorageSystem() {
        records = new TreeMap<>();
        indexMap = new HashMap<>();
        indexMap.put("Year", 4);
        indexMap.put("Month", 7);
        indexMap.put("Day", 10);
        indexMap.put("Hour", 13);
        indexMap.put("Minute", 16);
        indexMap.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        records.putIfAbsent(timestamp, new HashSet<Integer>());
        records.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        int index = indexMap.get(granularity);
        //start = "2016:01:01:01:01:01", end = "2017:01:01:23:00:00"
        //left = "2016" + ":01:01:00:00:00", right = "2017" + ":12:31:23:59:59"
        String left = start.substring(0, index) + min.substring(index);
        String right = end.substring(0, index) + max.substring(index);
        Map<String, HashSet<Integer>> subMap = records.subMap(left, true, right, true);
        List<Integer> results = new ArrayList<>();
        for(String key : subMap.keySet()){
            results.addAll(subMap.get(key));
        }
        return results;
    }

    /*
     //Time = O(n)
    List<String[]> records;
    Map<String, Integer> indexMap;
    public LogSystem() {
        records = new ArrayList<>();
        indexMap = new HashMap<>();
        indexMap.put("Year", 4);
        indexMap.put("Month", 7);
        indexMap.put("Day", 10);
        indexMap.put("Hour", 13);
        indexMap.put("Minute", 16);
        indexMap.put("Second", 19);
    }

    public void put(int id, String timestamp) {
         records.add(new String[]{id+"", timestamp});
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
         List<Integer> results = new ArrayList<>();
         int index = indexMap.get(granularity);
         for(String[] rd : records){
              if(rd[1].substring(0, index).compareTo(start.substring(0, index)) >= 0 &&
                 rd[1].substring(0, index).compareTo(end.substring(0, index)) <= 0){
                  results.add(Integer.parseInt(rd[0]));
              }
         }
        return results;
    }
     */
}
