package Heap.Medium;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _2182_ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int limit) {
        int[] bank = new int[26];
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i=0; i<26; i++){
            if(bank[i]==0) continue;
            pq.add(new int[]{i, bank[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            boolean finish = false;
            while(cell[1] > 0){
                //append the larger char first
                int time = Math.min(cell[1], limit);
                for(int i=0; i<time; i++){
                    sb.append((char)(cell[0]+'a'));
                }
                cell[1] -= limit;
                if(cell[1] <= 0) finish = true;
                //if freq of max char is not finish, then we need to
                //append another second max freq char to seperate two same groups
                //at the same time, we need to update the freq of it
                if(!finish){
                    if(pq.isEmpty()) break;
                    sb.append((char)(pq.peek()[0]+'a'));
                    pq.peek()[1]--;
                    finish = false;
                }
                //if found there is zero on the top , remove it
                if(!pq.isEmpty() && pq.peek()[1]==0) pq.remove();
            }
        }
        return sb.toString();
    }
}
