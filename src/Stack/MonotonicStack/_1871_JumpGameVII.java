package Stack.MonotonicStack;

import java.util.LinkedList;
import java.util.Queue;



/**
 * Created by Shuhua Song
 */
public class _1871_JumpGameVII {
    //Sliding Widow + Heap
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        int n= s.length();
        q.add(0);
        for(int i=0; i<n && i!=-1; i=s.indexOf("0", i+1)){ //find the index of '0' sart from i+1, when there is no index, it will return -1
            while(!q.isEmpty() && i-q.peek()>maxJump){
                q.poll();
            }
            if(!q.isEmpty() && i-q.peek() >= minJump){ //also need to check if the[q.peek(), curr_index ] is greater than minJump
                q.offer(i);
                if(i==n-1) return true;
            }
            if(q.isEmpty()) return false;
        }
        return false;
    }
}
