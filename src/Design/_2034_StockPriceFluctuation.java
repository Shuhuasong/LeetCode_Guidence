package Design;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _2034_StockPriceFluctuation {

    //Use a sorted data structure -- like a binary search tree
    // Time = O(logn) for each function
    // Space = O(n)
    TreeMap<Integer, Integer> records = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> priceTotimeSet = new TreeMap<>();

    public _2034_StockPriceFluctuation() {

    }

    public void update(int timestamp, int price) {
        if(records.containsKey(timestamp)){
            int prevPrice = records.get(timestamp);
            Set<Integer> times = priceTotimeSet.get(prevPrice);
            times.remove(timestamp);
            if(times.isEmpty()){
                priceTotimeSet.remove(prevPrice);
            }
        }
        if(!priceTotimeSet.containsKey(price)){
            priceTotimeSet.put(price, new HashSet<>());
        }
        priceTotimeSet.get(price).add(timestamp);
        records.put(timestamp, price);
    }

    public int current() {
        return records.lastEntry().getValue();
    }

    public int maximum() {
        return priceTotimeSet.lastKey();
    }

    public int minimum() {
        return priceTotimeSet.firstKey();
    }
}
