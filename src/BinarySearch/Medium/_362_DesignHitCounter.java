package BinarySearch.Medium;

import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _362_DesignHitCounter {
    //Time = O(logN), Space = O(N)
    TreeMap<Integer, Integer> record;
    int count = 0;
    public _362_DesignHitCounter() {
        record = new TreeMap<>();
        record.put(0, 0);
    }

    public void hit(int timestamp) {
        count++;
        record.put(timestamp, count);
    }

    public int getHits(int timestamp) {
        Integer latestTime = record.floorKey(timestamp);
        Integer beginTime = record.floorKey(timestamp-300);
        if(beginTime==null){
            beginTime= record.ceilingKey(timestamp-300);
            System.out.println(timestamp + "-" + beginTime);
        }
        System.out.println(latestTime + " " + beginTime);
        int res = record.get(latestTime) - record.get(beginTime);
        return res;
    }

    /*
     //Time = O(logN), Space = O(N)
    private Queue<Integer> records;
    public HitCounter() {
       records = new LinkedList<>();
    }
    //Time = O(1)
    public void hit(int timestamp) {
       records.add(timestamp);
    }
    //Time = O(n), worst case, when removing all the time from queue
    public int getHits(int timestamp) {
        while(!records.isEmpty()){
            int diff = timestamp-records.peek();
            if(diff >= 300){
                records.remove();
            }else
                break;
        }
        return records.size();
    }
     */
}
