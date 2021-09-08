package Golden_Sach_21FallOA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
//The same question with LC-239
public class DisckSpaceAnalyse {

    private static int getMaximum(int[] nums, int k){
        if(nums==null || nums.length==0 || k > nums.length) return 0;

        int[] res = new int[nums.length-k+1];
        //Deque store the index of max number in window
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;

        while(i<nums.length){
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] >= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }
        int ans = Integer.MIN_VALUE;
        for(int r : res){
            ans = Math.max(ans, r);
        }
        return ans;
      /*  if(space==null || space.length==0 || x==0) return 0;
        int l = 0,  maxVal = 0, currMin = 0;
        Set<Integer> seen = new HashSet<>();
        for(int r=0; r<=space.length-x; r++){
            currMin = Integer.MAX_VALUE;
            for(int j=r; j<r+x; j++){
                currMin = Math.min(currMin, space[j]);
            }
            seen.add(currMin);
        }
        for(int num : seen){
            System.out.print(num + "  ");
            maxVal = Math.max(currMin, num);
        }
        return maxVal; */
    }

    public static void main(String[] args) {
        int[] space = {8, 2, 4, 6};
        int x = 2;
        System.out.println(getMaximum(space, x));
    }
}
