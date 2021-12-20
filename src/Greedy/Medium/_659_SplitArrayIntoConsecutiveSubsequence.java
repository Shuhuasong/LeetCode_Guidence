package Greedy.Medium;

import java.util.HashMap;

/**
 * Created by Shuhua Song
 */
public class _659_SplitArrayIntoConsecutiveSubsequence {
    public boolean isPossible(int[] nums) {
        //key : ending number, val: how many sequence
        HashMap<Integer, Integer> seq = new HashMap<>();
        //key : number, val : how many keys are unchecked
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int a : nums){
            count.put(a, count.getOrDefault(a, 0)+1);
        }
        for(int a : nums){
            if(count.get(a)==0) continue; // should check if the elem has been used before
            if(seq.getOrDefault(a-1, 0) > 0){ //combine with previous sequence
                seq.put(a-1, seq.get(a-1)-1);
                seq.put(a, seq.getOrDefault(a, 0)+1);
            }else{
                //start from this element, and connect with elem on right side, e.g {6, 7, 8}
                if(count.getOrDefault(a+1, 0)==0 ||
                        count.getOrDefault(a+2, 0)==0){ return false; }
                //mark the back elems have been used
                count.put(a+1, count.get(a+1)-1);
                count.put(a+2, count.get(a+2)-1);
                seq.put(a+2, seq.getOrDefault(a+2, 0)+1);
            }
            count.put(a, count.getOrDefault(a, 0)-1);
        }
        return true;
    }
}

/*
idea:
2 X 3 X 4 X [5]   X X 6 X 7
X X X X X X 6     X X 7 X 8
nums = {1, 1, 2, 2, 3, 3, 4}
seq[3] = 2
after add 4 into the sequence of {1, 2, 3}
seq[4] += 1
seq[3] -= 1
*/

