package Array.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
Description
Given an list interval, which are taking off and landing time of the flight. How many airplanes are
there at most at the same time in the sky?

Example 1:

Input: [(1, 10), (2, 3), (5, 8), (4, 7)]
Output: 3
Explanation:
The first airplane takes off at 1 and lands at 10.
The second ariplane takes off at 2 and lands at 3.
The third ariplane takes off at 5 and lands at 8.
The forth ariplane takes off at 4 and lands at 7.
During 5 to 6, there are three airplanes in the sky.

Example 2:

Input: [(1, 2), (2, 3), (3, 4)]
Output: 1
Explanation: Landing happen before taking off.
 */

public class _391_NumberOfAirplaneInTheSky {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /*
    Solution: when there is a interval.start, an airplane take off ===> count++,
              when there is a interval.end, an airplane land ===> count--;
    first, we seperate all the start  and end into list and sort them;
    if it is start, then add 1; otherwise, we substract 1, and keep an max in the global */

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<int[]> list = new ArrayList<>();
        for(Interval a : airplanes){
            list.add(new int[]{a.start, 1});
            list.add(new int[]{a.end, -1});
        }
        Collections.sort(list, (a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int count = 0, res = 0;
        for(int[] p : list){
            count += p[1];
            res = Math.max(res, count);
        }
        return res;
    }

}
