package HashTable.Medium;

import java.sql.Time;
import java.util.*;

public class _729_MyCalendar_I {


/* solution-brute force
   Time = O(n^2) Space = O(n)
   //for each event, it needs to go back to check previous events
    Set<int[]> calendar;
    public _729_MyCalendar_I() {
        calendar = new HashSet<>();
    }
    public boolean book(int start, int end) {
        for(int[] cal : calendar){
            if(start < cal[1] && end > cal[0]){
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
 */

    //Solution#2 -- Balanced Tree
    //Time = O(nlogn)  Space = (n)
    // n = events booken, logn = search the event if is legal
    private TreeMap<Integer, Integer> calendar;

    public _729_MyCalendar_I() {
        calendar = new TreeMap<>();
    }

   /*  public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prevCal = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> nextCal = calendar.ceilingEntry(start);
        if(prevCal != null && prevCal.getValue() > start ||
                nextCal != null && nextCal.getKey() < end){
            return false;
        }
        calendar.put(start, end);
        return true;
    } */

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);// calendar.get(prev) = the end of an event
        if ((prev != null && calendar.get(prev) > start) ||
                (next != null && next < end)) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}


/*
case 1:           cal[0]  |__________| cal[1]
        start    |_______________________|  end

case 2:          cal[0] |_____________|cal[1]
        start  |________________| end

only the conddition: start < cal[1] && end > cal[0] can cover these two cases
hower, the condition : start >= cal[0] && start < cal[1] || end > cal[0] && end <= cal[1]
   can't conver both, it only cover case 2, that is why it doesn't work

*/


/*
floor	Java floor method returns the largest integer that is less than or equal to the argument
ceil	Math ceil function in Java returns the smallest integer that is greater than or equal to the argument
floorEntry returns an entry with largest key that is less than or equal to the argument
ceilingEntry returns an entry with  smallest key that is greater than or equal to the argument
 */


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */