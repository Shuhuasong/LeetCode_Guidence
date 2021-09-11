package OnlineCodingChallege.Citadel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _DiskSpaceAnalysis {

    private static int MaxFromMin(int[] space, int k){
        int n = space.length;
        int[] nums = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        while(i<n){
            if(!dq.isEmpty() && i-dq.peek()==k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && space[dq.peekLast()] >= space[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                nums[i-k+1] = space[dq.peekFirst()];
                //System.out.println(space[dq.peekFirst()] + " ");
            }
            i++;
        }
        int res = 0;
        for(int num : nums){
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] space = {8, 2, 4, 6};
        int segment = 2;
        System.out.println(MaxFromMin(space, segment));
    }
}
