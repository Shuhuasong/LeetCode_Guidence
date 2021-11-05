package Design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */

class LRUCache extends LinkedHashMap<Integer, Integer>{

    int capacity;
    //This constructor is also used to initialize both the capacity and fill ratio for a LinkedHashMap along with whether to follow the insertion order or not.
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // Returns true if this map should remove its eldest entry.
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}

