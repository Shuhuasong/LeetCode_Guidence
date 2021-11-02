package HashTable.Medium;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _981_TimeBasedKeyValueStore {

    HashMap<String, TreeMap<Integer, String>> records;
    public _981_TimeBasedKeyValueStore() {
        records = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!records.containsKey(key)){
            records.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> treeM = records.get(key);
        treeM.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!records.containsKey(key)) return "";
        TreeMap<Integer, String> treeM = records.get(key);
        if(treeM.containsKey(timestamp)){
            return treeM.get(timestamp);
        }
        Integer time = treeM.floorKey(timestamp);
        if(time==null) return "";
        return treeM.get(time);
    }
}
