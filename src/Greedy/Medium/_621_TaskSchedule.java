package Greedy.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _621_TaskSchedule {

    //Time = O(n)
    public int leastInterval(char[] tasks, int n) {
        //n+1 : need to have n tasks in between two same tasks, A, x1, x2, ...xn A
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int tail = 0; //the number character which has maxFreq(last row)
        for(char t : tasks){
            freq.put(t, freq.getOrDefault(t, 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(t));
        }
        for(int f : freq.values()){
            if(f==maxFreq) tail++;
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1)+tail);
    }


    /*
     //Time = nlogn
    public int leastInterval(char[] tasks, int n) {
        n++; //need to have n tasks in between two same tasks, A, x1, x2, ...xn A
        Map<Character, Integer> freq = new HashMap<>();
        for(char t : tasks){
             freq.put(t, freq.getOrDefault(t, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b)->freq.get(b)-freq.get(a));
        for(char key : freq.keySet()){
            pq.add(key);
        }
        int res = 0;
        while(!pq.isEmpty()){
            int k = Math.min(n, pq.size());
            List<Character> temp = new ArrayList<>();
            for(int i=0; i<k; i++){
                char ch = pq.poll();
                int times = freq.get(ch);
                times--;
                if(times!=0){
                   temp.add(ch);
                   freq.put(ch, times);
                }
            }

            if(temp.size()>0){ //[ABXX][AB]
               //still have elements need to push into queue
                res += n;
            }else{
                //last round, don't need to add IDLE
                res += k;
            }

            for(char c : temp) pq.add(c);
        }
        return res;
    }

 /*
Solutiong-1: Max Heap (simulation)
1) count the frequence for each task
2) sort the tasks according to their frequency
3) when heap is not empty, take out Math.min(n, heap.size())
   items

freq = {[A, 8], [B, 6], [C, 4], [D, 2]}
PQ = {A, B, C, D}

Solution-2: Greedy(Optimize)

A, B : maxFreq
C    :  f_c
D    :  f_d
...
H    :
I    :

A B C D G
A B C D X-->IDLE
A B C E X
A B C F X
A B

A B C D G
A B C D H
A B C E I
A B C F J
A B


*/



    /*
Greedy:
# CPU = #tasks + #idle slots
Maximum possible number of idle slots is defined by the frequency of the most
frequent task: idle_time <= (fMax-1) * n
So to compute the minimum number of idle slots, we can use greedy
the idea is to sort the tasks by frequency in the descending order and
fullfill as many idle slots as possible
e.g :      A B A A B C A A     n = 2, idleTime = (5-1)*2 = 8
      A B C A B _ A _ _ A _ _ A
schedule the next by frequency task B ====> idleTime = 8 - min(fMax-1, freqB) = 6
schedule the next by frequency task C ====> idleTime = 8 - min(fMax-1, freqC) = 5

A--->5
B--->2
C--->1

result = tasks.length + idleTime = 8 + 5 = 13

    public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0) return 0;
        if(n==0) return tasks.length;
        int[] count = new int[26];
        for(char c : tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        //Arrays.sort(count, (a, b)->b-a);
        int idleTime = (count[25]-1) * n;
        int fMax = count[25];
        for(int i=24; i>=0 && idleTime>0; i--){
            idleTime -= Math.min(fMax-1, count[i]);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length+idleTime;
    }  */


      /*
Math-2 situation
1) the most frequent task is not frequent enought to force the precent of idle slots
    A B C D E A F A
    A B C A D E A F
      ___   ___   cooling period  = 2
2) the most frequent task is frequent enough to force some idle slots
   A B A A B C A A
   A B C A B _ A _ _ A _ _ A

e.g:   A B C A B D A B _ A B    fMax = fa = fb = 4
       _____ _____ _____ ___
there are (fMax-1) groups "tasksA + cooling period"
each group has (1+n), 1 for executing A, n for cooling period
last group is  Nmax = 2, there are two most frequent tasks A, and B


 public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0) return 0;
        if(n==0) return tasks.length;
        int[] count = new int[26];
        for(char c : tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        //Arrays.sort(count, (a, b)->b-a);
        int fMax = count[25];
        int Nmax = 0;
        for(int c : count){
            if(c==fMax) Nmax++;
        }
        return Math.max(tasks.length, (fMax-1)*(n+1)+Nmax);
    }

*/




}



