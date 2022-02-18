package Heap.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _759_EmployeeFreeTime {

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    //N = # of workers or schedule's size, M = the max number of schedule for each worker
    //Time = O(M*NlogMN)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        //e1 = {0, 0} = {#of employ, #of schedule}
        List<Interval> results = new ArrayList<>();
        if(schedule.size() <= 1) return results;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2)->
                schedule.get(e1[0]).get(e1[1]).start-schedule.get(e2[0]).get(e2[1]).start);
        //Add the first schdule time for each worker
        for(int i=0; i<schedule.size(); i++){
            pq.offer(new int[]{i, 0});
        }

        int prevIndex = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            Interval currInter = schedule.get(cell[0]).get(cell[1]);
            if(currInter.start > prevIndex){
                Interval newInter = new Interval(prevIndex, currInter.start);
                results.add(newInter);
            }
            prevIndex = Math.max(prevIndex, currInter.end);
            //have more schedule for the cell[0] th worker, we keep add the schedule into queue
            if(schedule.get(cell[0]).size() > cell[1]+1){
                pq.offer(new int[]{cell[0], cell[1]+1});
            }
        }
        return results;
    }
}
