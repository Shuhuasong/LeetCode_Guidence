package Greedy.Medium;

import java.util.HashSet;
import java.util.Set;

//Time = O(n) Space = O(1)
//idea: first we need to record the frequency of each character
//then, use a set to check if there is a duplicate frequency, if is duplicate, we substract 1 on the frequency until it is
// not repeat in the set

public class _1647_MinimumDeleteToMakeCharFrequencyUnique {

    public int minDeletions(String s) {
        int[] bank = new int[26];
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for(int val : bank){
            while(val != 0 && seen.contains(val)){
                res += 1;
                val -= 1;
            }
            seen.add(val);

        }
        System.out.println("Test");
        return res;
    }
}
