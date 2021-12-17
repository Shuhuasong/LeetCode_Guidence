package Design;

import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _729_MyCalendarI {

    //Time = O(nlogn), space = O(n)
    TreeMap<Integer, Integer> events = new TreeMap<>();
    public _729_MyCalendarI() {

    }

    public boolean book(int start, int end) {
        if(events.size()==0){
            events.put(start, end);
            return true;
        }
        Integer prev = events.floorKey(start);
        Integer next = events.ceilingKey(start);
        if((prev==null || events.get(prev) <= start) && (next==null || end<=next)){
            events.put(start, end);
            return true;
        }
        return false;
    }

    /*
      //Time = O(n^2), space = O(n)
    List<int[]> list = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if(list.size()==0){
            list.add(new int[]{start, end});
            return true;
        }
        for(int[] item : list){
            if(start < item[1] && item[0] < end){
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
     */


    /*
  Two events: [s1, e1], [s2, e2]
               |_______|             |________|
              s1      e1             s2       e2
                   |________|             |________|
                   s2       e2            s1       e1
  conflict:  s2 < e1 && s1 < e2
  */
    
}
