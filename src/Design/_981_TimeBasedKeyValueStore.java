package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _981_TimeBasedKeyValueStore {

    /** Initialize your data structure here. */
    Map<String, TreeMap<Integer, String>> timeMap;
    public _981_TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new TreeMap<Integer, String>());
        }
        timeMap.get(key).put(timestamp, value);

    }
    //floorKey(time) : return the largest value that is less than given value
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        TreeMap<Integer, String> tree = timeMap.get(key);
        Integer t = tree.floorKey(timestamp);
        if(t==null) return "";
        else{
            return tree.get(t);
        }
    }
}
