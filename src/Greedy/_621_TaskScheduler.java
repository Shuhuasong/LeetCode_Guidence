package Greedy;

import java.util.Arrays;

public class _621_TaskScheduler {

    //Time = O(n) Space = O(n)
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq-1) * n;
        for(int i=0; i<freq.length-1 && idleTime>0; i++){
            idleTime -= Math.min(maxFreq-1, freq[i]);
        }

        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
